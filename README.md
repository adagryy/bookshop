# bookshop
Classes from software testing

Co trzeba zrobic?
1. Baze MySQLową dla bookshopu
2. CRUD dla bookshopu
2.1 metody CRUD w JAVIE z użyciem hibertane

3.  Przetestowanie tych metod


Uruchamiamy w Intellij Ctrl + Shift + F10.

    public static void main(final String[] args) throws Exception {
        Main m = new Main();

        BooksEntity be = new BooksEntity();

        int record = 4; <-- podajemy numer rekordu, który chcemy usunąć, albo numer następnego rekordu do dodania

        be.setId(record);
        be.setTitle("The lord of the Rings");
        be.setAuthor("Jakis tam");
        be.setPrice(new BigDecimal(9.99));
        be.setKategoria(2);
        be.setWydawnictwo_id(3);

        m.addRecord(be); <-- na razie jest to trochę sztywne, trzeba komentować, żeby wykonywać różne akcje (dodawanie, czy usuwanie)

        //m.updateRecord(be);

        //m.deleteRecord(record);
    }
