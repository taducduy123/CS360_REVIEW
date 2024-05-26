public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.addPlayer(new Player("Duy"));
        game.addPlayer(new Player("DUY111111"));
        game.start();
    }
}
