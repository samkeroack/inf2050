public abstract class Animal {
    protected String cri;
    protected int age = 1;

    public Animal (String cri, int age) {
        this.cri = cri;
        this.age = age +3;
    }
    public Animal () {
        System.out.println(toString());
        this.cri = "chikedi";
        age++;
    }
    public abstract String jeMange();

    public String manger(){
        return "je mange" + jeMange();
        }

        public void jeSuis() {
            System.out.println(toString() + " (" + age + " ans)");
        }
        public String toString() {
            return "Animal";
        }


}
