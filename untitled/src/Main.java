public class Main {
    public static void main(String[] args) {

        ToyShop toyShop = new ToyShop();



        // Добавляем игрушки

        Toy toy1 = new Toy(1, "Кукла", 10, 20);

        Toy toy2 = new Toy(2, "Машинка", 5, 30);

        toyShop.addToy(toy1);

        toyShop.addToy(toy2);



        // Изменяем частоту выпадения игрушек

        toyShop.setToyFrequency(1, 15);

        toyShop.setToyFrequency(2, 25);



        // Организуем розыгрыш

        toyShop.drawToys();

    }
}