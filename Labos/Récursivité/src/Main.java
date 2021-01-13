public class Main {
    public static void main(String[] args) {
        System.out.println(Récursivité.moo(756));
        int [] tab = {1, 2, 3, 4, 5, 6};
        try {
            System.out.println(Récursivité.mystere(3, tab));
        }catch(Exception e){
            System.out.println("Erreur");
        }
        System.out.println(Récursivité.sommerEgaux(1, 111));
    }


}
