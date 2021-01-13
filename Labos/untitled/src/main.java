public class main {
    public static void main(String[] args) {
        public static void traceListe2() {
            Maillon<Integer> m = new Maillon<>(5);
            Maillon<Integer> m2 = m;
            Maillon<Integer> m4 = new Maillon<>(9, new Maillon<>(8));
            Maillon<Integer> m5 = m4.suivant();
            Maillon<Integer> m3;
            for (int i = 1; i < 5; i++) {
                m2.modifierSuivant(new Maillon<>(i));
                m2 = m2.suivant();
            }
            m3 = m.suivant();
            m.modifierSuivant(m2);
            m2 = m3.suivant();
            m.suivant().modifierSuivant(m2.suivant());
            m2.suivant().modifierSuivant(m2);
            m3.modifierInfo(6);
            m2.modifierSuivant(m3);
            m3.modifierSuivant(m);
            m5.modifierSuivant(new Maillon<>(7));
            m5.suivant().modifierSuivant(m3);
            m4 = new Maillon<>(10, m4);
            m2.modifierSuivant(new Maillon<>(1));
            while (m4 != null) {
                System.out.print(m4.info() + " ");
                m4 = m4.suivant();
            }
        }
    }
}
