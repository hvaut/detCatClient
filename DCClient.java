public class DCClient extends Client {

    private List<Player> players;
    private String name, turn;

    private int firstPile, pile, placed;
    private boolean inGame, loggedIn;

    private MainWindow window;

    public DCClient(String ip, int port) {
        super(ip, port);

        players = new List<>();

        window = new MainWindow(this);
        window.setVisible(true);
    }

    public void processMessage(String pMessage) {
        String[] data = pMessage.split(" ");

        // make sure the array is not empty
        if (data.length < 1) {
            send("-ERR Wrong command");
            return;
        }

        // used in commands to easier process their arguments
        String details = pMessage.substring(data[0].length()).trim();

        // handle every command
        if (data[0].equalsIgnoreCase("+OK")) {
            // command is successfully (log)
            if (details.contains("Logged in")) {
                loggedIn = true;
            } else if (details.contains("Logged out")) {
                loggedIn = false;
            }
        } else if (data[0].equalsIgnoreCase("-ERR")) {
            // error was thrown at a command (log)
            if (!inGame && loggedIn) {
                // log player out if it failed
                send("LOGOUT");
            }
            // show error
            window.popupError(details);
        } else if (data[0].equalsIgnoreCase("BOMB") && data.length == 2) {
            // player received a bomb
            if (data[1].equalsIgnoreCase(name)) {
                // if we received it we need to defuse it
                window.popupDefuse();
            }
        } else if (data[0].equalsIgnoreCase("PLACE") && data.length == 3) {
            // Placing a card
            String player = data[1];
            Card card = Card.getCard(data[2]);
            // validate inputs
            if (player != null && card != null) {
                // update placed card
                window.getGamePanel().updatePlacedCard(card);
            }
            // increase place count
            placed++;
        } else if (data[0].equalsIgnoreCase("TAKE") && data.length == 2) {
            // do nothing because we will get a card update message
        } else if (data[0].equalsIgnoreCase("TURN") && data.length == 2) {
            // update status to in-game
            inGame = true;
            // update current active player
            turn = data[1];
            // update pile count
            send("PILE");
            // update turn in windows
            window.getGamePanel().markPlayer(turn);
        } else if (data[0].equalsIgnoreCase("JOIN") && data.length == 2) {
            // add the player
            addPlayer(data[1]);
            // check if we are the player
            if (data[1].equalsIgnoreCase(name)) {
                // reset all data
                reset();
                // update windows
                window.getGamePanel().reset();
                window.switchToGame();
            }
            // update players
            window.getGamePanel().updateNamesOrdered(false);
        } else if (data[0].equalsIgnoreCase("QUIT") && data.length == 2) {
            // set the player to dead if the game started
            if (inGame) {
                Player player = getPlayer(data[1]);
                if (player != null) {
                    player.setAlive(false);
                }
            }
            // remove player from list
            removePlayer(data[1]);
            // update players
            window.getGamePanel().updateNamesOrdered(inGame);
            // check if we left
            if (data[1].equalsIgnoreCase(name)) {
                // reset all data
                reset();
                // update windows
                window.getGamePanel().reset();
                window.switchToLogin();
            }
        } else if (data[0].equalsIgnoreCase("DEATH") && data.length == 2) {
            // a player died
            Player player = getPlayer(data[1]);
            if (player != null) {
                player.setAlive(false);
            }
            // update players
            window.getGamePanel().updateNamesOrdered(true);
            // check if we died
            if (data[1].equalsIgnoreCase(name)) {
                // we are dead :(
                window.popupDeath();
            }
        } else if (data[0].equalsIgnoreCase("WIN") && data.length == 2) {
            // winner is announced
        } else if (data[0].equalsIgnoreCase("CARD") && data.length >= 2) {
            // update cards on hand
            String[] cards = details.split(" ");
            // reset cards because they get counted again
            for (Card card : Card.values()) {
                card.setCount(0);
            }
            // for every card we increase their count
            for (String cardId : cards) {
                Card card = Card.getCard(cardId);
                // if card is existing then increase their count by 1
                if (card != null) {
                    card.setCount(card.getCount() + 1);
                }
            }
            // update card counts
            window.getGamePanel().updateCardCounts();
        } else if (data[0].equalsIgnoreCase("PLAYER") && data.length >= 2) {
            // update players
            players = new List<>();
            // for every player add them individually
            for (String player : details.split(" ")) {
                addPlayer(player);
            }
            // update players
            window.getGamePanel().updateNamesOrdered(false);
        } else if (data[0].equalsIgnoreCase("PILE") && data.length == 2) {
            // update pile count
            pile = Integer.parseInt(data[1]);
            // set first pile for progress calculations
            if (firstPile == 0) {
                firstPile = pile;
            }
            // update progress in windows
            window.getGamePanel().updateProgress();
        }
    }

    public void reset() {
        players = new List<>();
        turn = null;
        firstPile = 0;
        pile = 0;
        placed = 0;
        inGame = false;
    }

    public void setName(String pName) {
        name = pName;
    }

    public void takeCard() {
        send("TAKE");
    }

    public void placeCard(Card card) {
        send("PLACE " + card.getId());
    }

    public void defuseCard(int indexInPercent) {
        send("DEFUSE " + indexInPercent);
    }

    public void hostGame(String pCode) {
        send("LOGIN " + name);
        send("HOST " + pCode);
    }

    public void joinGame(String pCode) {
        send("LOGIN " + name);
        send("JOIN " + pCode);
    }

    public void leaveGame() {
        send("LOGOUT");
    }

    /**
     * Methode addPlayer
     *
     * @param player Player hinzufügen
     *
     * Aufgabe: Liste durchgehen und einen Spieler hinzufügen
     */
    public void addPlayer(String player) {
        players.append(new Player(player));
    }

    /**
     * Removes a player
     *
     * @param player player to remove
     *
     * Aufgabe: liste aller Spieler durchgehen und den ausgewählten Spieler aus der Liste entfernen
     */
    public void removePlayer(String player) {
        players.toFirst();
        while (players.hasAccess()) {
            if (players.getContent().getName().equalsIgnoreCase(player)) {
                players.remove();
                return;
            }
            players.next();
        }
    }

    public Player getPlayer(String player) {
        players.toFirst();
        while (players.hasAccess()) {
            if (players.getContent().getName().equalsIgnoreCase(player))
                return players.getContent();
            players.next();
        }
        return null;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getTurn() {
        return turn;
    }

    public String getName() {
        return name;
    }

    public int getFirstPile() {
        return firstPile;
    }

    public int getPile() {
        return pile;
    }

    public int getPlaced() {
        return placed;
    }

    public boolean isTurn() {
        return turn.equalsIgnoreCase(name);
    }

    public boolean isInGame() {
        return inGame;
    }

}
