class testing {
    public static void main(String[] args) {
        String str = "e7M3";
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i+1).matches("[a-zA-Z]")) {
                System.out.println(str.charAt(i));
            }
        }

        int [][] party = {
                {0,0,0,0},
                {1,0,0,1},
                {1,0,0,1},
                {1,1,1,0},
        };
        System.out.println(party.length);
    }
}
