package designpattern.adapter;

public class EnemyAttackerAdapter implements EnemyAttacker{
    EnemyAttackerIncompatibles newAttacker;

    public EnemyAttackerAdapter(EnemyAttackerIncompatibles newAttacker){
        this.newAttacker = newAttacker;
    }

    @Override
    public void fireWeapon() {
        newAttacker.smashWithHands();
    }

    @Override
    public void driveForward() {
        newAttacker.walk();
    }

    @Override
    public void assignDriver(String name) {
        newAttacker.whoAreYou(name);
    }
}
