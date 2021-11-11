package polymorphisms;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/4/20 17:01
 */
public class Peo {

    private People P;


    public Peo() {

    }

    public Peo(People p) {
        P = p;
    }

    public People getP() {
        return P;
    }

    public void setP(People p) {
        P = p;
    }
}
