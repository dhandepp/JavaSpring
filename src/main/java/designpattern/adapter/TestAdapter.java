package designpattern.adapter;

public class TestAdapter {
    public static void main(String[] args){
        EnemyAttacker tank = new EnemyTank();
        tank.assignDriver("John");
        tank.driveForward();
        tank.fireWeapon();

        EnemyAttacker ai = new EnemyAttackerAdapter(new EnemyAIAttacker());
        ai.assignDriver("Bush");
        ai.driveForward();
        ai.fireWeapon();
    }
}
