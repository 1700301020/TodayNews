package com.example.mvp.mvp;

import android.content.Intent;
import android.os.Bundle;

//抽象中介者
public interface ILifeCircle {

    void onCreate(Bundle saveInstanceState, Intent intent, Bundle getArguments);

    void onActivityCreated(Bundle saveInstanceState, Intent intent, Bundle getArguments);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void destroyView();

    void onViewDestroy();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onSaveInstanceState(Bundle bundle);

    void attachView(IMvpView iMvpView);
}
