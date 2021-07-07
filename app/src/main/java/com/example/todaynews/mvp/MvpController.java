package com.example.todaynews.mvp;

import android.content.Intent;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MvpController implements ILifeCircle{

    //储存P层的实例
    private Set<ILifeCircle> lifeCircles = new HashSet<>();

    public void savePresenter(ILifeCircle lifeCircle){
        //代理类与P层实例的关联
        this.lifeCircles.add(lifeCircle);
    }

    @Override
    public void onCreate(Bundle saveInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            if (getArguments == null) {
                getArguments = new Bundle();
            }
            next.onCreate(saveInstanceState,intent,getArguments);
        }
    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            if (getArguments == null) {
                getArguments = new Bundle();
            }
            next.onCreate(saveInstanceState,intent,getArguments);
        }
    }

    @Override
    public void onStart() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onStart();
        }
    }

    @Override
    public void onResume() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onResume();
        }
    }

    @Override
    public void onPause() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onPause();
        }
    }

    @Override
    public void onStop() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onStop();
        }
    }

    @Override
    public void onDestroy() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onDestroy();
        }
    }

    @Override
    public void destroyView() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.destroyView();
        }
    }

    @Override
    public void onViewDestroy() {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onViewDestroy();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            next.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if (data == null) {
                data = new Intent();
            }
            next.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if (bundle == null) {
                bundle = new Bundle();
            }
            next.onSaveInstanceState(bundle);
        }
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        Iterator<ILifeCircle> iterator = lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.attachView(iMvpView);
        }
    }
}
