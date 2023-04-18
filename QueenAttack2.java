//URl:https://www.hackerrank.com/challenges/queens-attack-2/problem
public static boolean isEqualDistance(int queenX,int queenY,int oX,int oY){
        return Math.abs(queenX-oX)==Math.abs(queenY-oY) ? true:false;
    }
    public static int queensAttack(int n, int k, int queenX, int queenY, List<List<Integer>> obstacles) {
        AtomicInteger top= new AtomicInteger(n - queenY);
        AtomicInteger bot= new AtomicInteger(queenY - 1);
        AtomicInteger right= new AtomicInteger(n - queenX);
        AtomicInteger left= new AtomicInteger(queenX - 1);

        AtomicInteger topRight= new AtomicInteger(Math.min(top.get(), right.get()));
        AtomicInteger topLeft= new AtomicInteger(Math.min(top.get(), left.get()));
        AtomicInteger botRight= new AtomicInteger(Math.min(bot.get(), right.get()));
        AtomicInteger botLeft= new AtomicInteger(Math.min(bot.get(), left.get()));

        if(obstacles !=null){
            obstacles.forEach((item)->{
                boolean isEqualDistance=isEqualDistance(queenX,queenY,item.get(0),item.get(1));
                //top
                if(item.get(0)==queenX && item.get(1)>queenY)
                    top.set(Math.min(top.get(),item.get(1)-queenY-1));
                //bot
                if(item.get(0)==queenX && item.get(1)<queenY)
                    bot.set(Math.min(bot.get(), queenY - item.get(1) - 1));
                //right
                if(item.get(0)>queenX && item.get(1) ==queenY)
                    right.set(Math.min(right.get(), item.get(0) - queenX-1));
                //left
                if(item.get(0)<queenX && item.get(1)==queenY)
                    left.set(Math.min(left.get(), queenX - item.get(0) - 1));

                //topright
                if(item.get(0)>queenX && item.get(1)>queenY && isEqualDistance)
                    topRight.set(Math.min(topRight.get(), item.get(0) - queenX - 1));
                //topLeft
                if(item.get(0)<queenX && item.get(1)>queenY && isEqualDistance)
                    topLeft.set(Math.min(topLeft.get(), queenX - item.get(0) - 1));
                //botright
                if(item.get(0)>queenX && item.get(1)<queenY && isEqualDistance)
                    botRight.set(Math.min(botRight.get(), item.get(0)-queenX - 1));
                //botleft
                if(item.get(0)<queenX && item.get(1)<queenY && isEqualDistance)
                    botLeft.set(Math.min(botLeft.get(), queenX - item.get(0) - 1));
            });
        }

        return top.get() + bot.get() + left.get() + right.get() + topLeft.get() + topRight.get() + botLeft.get() + botRight.get();
    }
