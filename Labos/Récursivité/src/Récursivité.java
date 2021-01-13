public class Récursivité {

    public static int moo (int n) {
        int t = 1;
        if (n == 0) {
            t = 0;
        } else {
            t = moo (n / 10) * 10 + n % 10 + 1;
        }
        return t;
    }

    public static int mystere (int i, int [] tab) throws Exception {
        int resultat;
        if (i < tab.length - 1 && i >= 0) {
            resultat = tab[i] + mystere(i + 1, tab);
        } else if (i == tab.length - 1){
            resultat = tab[i];
        } else {
            throw new Exception ("ERREUR");
        }
        return resultat;
    }

    /**
     * Retourne la somme des chiffres egaux a chiffre, contenus dans n.
     * Si chiffre n'est pas entre 0 et 9 inclusivement, la methode
     * retourne -1. Si n est negatif, la methode le considere positif.
     * @param chiffre, le chiffre a additionner toutes les fois qu'il est
     * present dans n.
     * @param n le nombre dont on veut additionner les chiffres egaux a chiffre.
     */
    public static int sommerEgaux(int chiffre, int n){
        int resultat=0;
        if(chiffre>0&&chiffre<9){
            if(n%10==chiffre){
                resultat=chiffre+sommerEgaux(chiffre, n/10);
            }else{
                resultat=sommerEgaux(chiffre, n/10);
            }

        }else {
            resultat = -1;
        }
        return resultat;
    }

    /**
     * Retourne la somme des chiffres egaux a chiffre, contenus dans n.
     * Si chiffre n'est pas entre 0 et 9 inclusivement, la methode
     * retourne -1. Si n est negatif, la methode le considere positif.
     * @param chiffre, le chiffre a additionner toutes les fois qu'il est
     * present dans n.
     * @param n le nombre dont on veut additionner les chiffres egaux a chiffre.
     */
    public static int sommerEgaux2(int chiffre, int n) {
        int somme;
        //cas d'erreur
        if (chiffre < 0 || chiffre > 9) {
            somme = -1;
            //cas n est negatif, on rappelle la methode
            //sur -n
        } else if (n < 0) {
            somme = sommerEgaux2(chiffre, -n);

            //cas de base : n n'a qu'un seul chiffre
        } else if (n < 10) {
            if (chiffre == n) {
                somme = chiffre;
            } else {
                somme = 0;
            }
            //cas recursifs
        } else {
            //si le dernier chiffre de n egale chiffre, on
            //ajoute chiffre a la somme.
            if (chiffre == n % 10) {
                somme = chiffre + sommerEgaux2(chiffre, n / 10);
            } else {
                somme = sommerEgaux2(chiffre, n / 10);
            }
            //resultat = sommerEgaux(chiffre, n / 10);
        }
        return somme;
    }


}
