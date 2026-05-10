# BATTLE-RPG GAME DESIGN

### 1. GAME DESIGN (HIGH LEVEL)

```
LOGIN → LOAD PLAYER → LEVEL START
        ↓
   QUIZ QUESTION
        ↓
   BATTLE ENEMY
        ↓
   WIN?
   ├── NO → GAME OVER
   └── YES
        ↓
   REWARD (points + score)
        ↓
   SHOP (buy weapons/health)
        ↓
   NEXT LEVEL
```

### 2. SYSTEM ARCHITECTURE
```
+-------------------+
|   Main Game       |
+-------------------+
        |
        v
+-------------------+
|  Game Controller  |
+-------------------+
        |
        +----------------------+
        |                      |
        v                      v
+------------+        +----------------+
| Player Sys |        | Enemy System   |
+------------+        +----------------+
        |
        v
+-------------------+
| Weapon System     |
+-------------------+
        |
        v
+-------------------+
| JSON Storage      |
+-------------------+
```

### 3. PLAYER DATA MODEL
```
Player
 ├── username
 ├── password
 ├── health
 ├── score
 ├── points
 ├── level
 ├── weapon
 └── inventory
```

### 4. COMBAT SYSTEM DESIGN
```
PLAYER TURN
   ├── Attack
   ├── Heal
   └── Use Item

ENEMY TURN
   └── Auto Attack

CHECK HEALTH
   ├── enemy HP ≤ 0 → WIN
   └── player HP ≤ 0 → LOSE

Damage Formula

Damage=WeaponDamage+Random(0,5)−EnemyDefense

Level Scaling

EnemyHP=30+(15×Level)
```

### 5. CLASS STRUCTURE
```
src/
 ├── main/
 │    └── Game.java
 ├── model/
 │    ├── Player.java
 │    ├── Enemy.java
 │    ├── Weapon.java
 │
 ├── system/
 │    ├── BattleSystem.java
 │    ├── ShopSystem.java
 │    ├── QuestionSystem.java
 │
 ├── data/
 │    ├── JSONManager.java
 │    ├── PlayerRepository.java
 │    ├── WeaponRepository.java
```