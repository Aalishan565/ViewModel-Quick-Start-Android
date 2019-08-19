package ayesha.viewmodelsample;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

public class MainActivityDataGenerator extends ViewModel {
    private final String TAG = this.getClass().getSimpleName();
    public MutableLiveData<String> randomNumber;

    public MutableLiveData<String> getRandomNumber() {
        if (randomNumber == null) {
            randomNumber=new MutableLiveData<>();
            createRandomNumber();
        }
        return randomNumber;
    }

    public void createRandomNumber() {
        Random random = new Random();
        randomNumber.setValue("Number" + random.nextInt(10 - 0) + 1);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("Main", "onCleared");
    }
}
