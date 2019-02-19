class RecursiveMult {
    public static void main(String args[]) {
        int product = recursiveMult(3, 8);
        System.out.println(product);
    }

    public static int recursiveMult(int a, int b) {
        // Base case: if the number equals 1 return b
        if (a == 1) {
            return b;
        } if (a == 0) {
            return 0;
        }

        return recursiveMult(a - 1, b) + b;
    }
}