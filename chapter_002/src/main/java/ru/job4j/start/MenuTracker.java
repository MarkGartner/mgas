package ru.job4j.start;

import ru.job4j.models.Item;
import ru.job4j.models.Task;

public class MenuTracker {

    private Input input;
    private Tracker tracker;

    private UserAction[] actions = new UserAction[7];
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[position++] = new AddItem("Add the new item", 0);
        this.actions[position++] = new ShowAllItens("Show all items", 1);
        this.actions[position++] = new FindByID("Find by ID", 2);
        this.actions[position++] = new FindByName("Find by name", 3);
        this.actions[position++] = new EditItembyID("Edit by ID", 4);
        this.actions[position++] = new MenuTracker.DeleteItem("Delete by ID", 5);
    }

    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(String name, int key) {
            super(name, key);
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the tasks's name: ");
            String desc = input.ask("Please enter the task's description: ");
            tracker.add(new Task(name, desc));
        }
    }

    private class ShowAllItens extends BaseAction {

        public ShowAllItens(String name, int key) {
            super(name, key);
        }

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            tracker.showAllItems(tracker.getAll());
        }
    }

    private static class FindByID extends BaseAction {

        public FindByID(String name, int key) {
            super(name, key);
        }

        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            String searchID = input.ask("Please enter ID: ");
            Item result = tracker.findByID(searchID);
            if (result != null) {
                tracker.displayItemInfo(result);
            } else {
                System.out.println("Sorry. No such item exists");
            }
        }
    }

    private static class FindByName extends BaseAction {

        public FindByName(String name, int key) {
            super(name, key);
        }

        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            String name  = input.ask("Please enter name of item: ");
            Item result = tracker.findByName(name);

            if (result != null) {
                tracker.displayItemInfo(result);
            } else {
                System.out.println("Sorry. No such item exists");
            }
        }
    }

    private class EditItembyID extends BaseAction {

        public EditItembyID(String name, int key) {
            super(name, key);
        }

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String editID = input.ask("Please enter ID: ");
            tracker.editItemByID(editID);

        }
    }

    private static class DeleteItem extends BaseAction {

        public DeleteItem(String name, int key) {
            super(name, key);
        }

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("PLease enter ID of the item to be deleted: ");
            tracker.deleteItem(id);
        }
    }
}
