import java.util.LinkedList;
import java.util.List;

public class Market implements QueueBehaviour, MarketBehaviour {
    private LinkedList<Actor> queue = new LinkedList<>();

    @Override
    public void takeInQueue(Actor actor) {
        acceptToMarket(actor);
    }

    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder()) {
                System.out.println("Принимаем заказ у " + actor.getName());
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : queue) {
            if (actor.isTakeOrder()) {
                System.out.println("Выдаем заказ " + actor.getName());
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        if (!queue.isEmpty()) {
            queue.removeFirst();
        }
    }

    @Override
    public void acceptToMarket(Actor actor) {
        queue.addLast(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        queue.removeAll(actors);
    }

    @Override
    public void update() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder()) {
                queue.add(actor);
            }
            if (actor.isTakeOrder()) {
                queue.remove(actor);
            }
        }
    }

    public void getInfo(){
        for (Actor actor:queue){
            if (actor.isMakeOrder) {
                System.out.println(actor.getName() + "готовится заказ");
            }
            else {
                System.out.println(actor.getName() + "забирает заказ");
            }
        }
    }
}

