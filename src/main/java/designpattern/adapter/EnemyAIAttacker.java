package designpattern.adapter;

public class EnemyAIAttacker implements EnemyAttackerIncompatibles {

    @Override
    public void smashWithHands() {
        System.out.println("AI Attacker is firing");
    }

    @Override
    public void walk() {
        System.out.println("AI attacker is moving");
    }

    @Override
    public void whoAreYou(String name) {
        System.out.println("AI attacker name is "+name);
    }
}
