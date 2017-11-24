package ru.job4j.start;

import ru.job4j.models.Item;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String SHOWALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAllItems(this.tracker.getAll());
            } else if (FINDID.equals(answer)) {
                String id = this.input.ask("Введите ID заявки: ");
                Item result = this.tracker.findByID(id);
                displayItemInfo(result);
            } else if (FINDNAME.equals(answer)) {
                String name = this.input.ask("Введите имя запрашиваемой заявки: ");
                Item result = this.tracker.findByName(name);
                displayItemInfo(result);
            } else if (EDIT.equals(answer)) {
                String id = this.input.ask("Введите ID заявки, которую хотите изменить: ");
                Item result = this.tracker.editItemByID(id);
                displayItemInfo(result);
            } else if (DELETE.equals(answer)) {
                String id = this.input.ask("Введите ID заявки, которую хотите удалить: ");
                this.tracker.deleteItem(id);

            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой языки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showMenu() {
        System.out.println("Меню.");
        // добавить остальные пункты меню.
        System.out.println("0. Add new Item\n" + "1. Show all items\n" + "2. Edit item\n" + "3. Delete item\n" + "4. Find item by Id\n" + "5. Find items by name\n" + "6. Exit Program\n");
    }

    private void showAllItems(Item[] items) {
        System.out.println("--------------------------------------------");
        for (Item item : items) {
            System.out.println(item.name + ": " + item.description);
        }
        if (items.length == 0) {
            System.out.println("-----------В трекере нет заявок.------------");
        }
        System.out.println("--------------------------------------------");

    }


    private void displayItemInfo(Item item) {
        if (item != null) {
            System.out.println("--------------------------------------------");
            System.out.println("Данные заявки: " + item.name + " " + item.description);
            System.out.println("--------------------------------------------");
        } else {
            System.out.println("--------------------------------------------");
            System.out.println("По данному запросу ничего не найдено.");
            System.out.println("--------------------------------------------");
        }
    }


    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }


}
