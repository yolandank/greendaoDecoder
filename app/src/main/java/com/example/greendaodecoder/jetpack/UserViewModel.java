package com.example.greendaodecoder.jetpack;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {
    private MutableLiveData<String> name = new MutableLiveData<>();
    private int CLICKED_COUNT = 0;

    public UserViewModel() {
        super();

    }

    public LiveData<String> getNameData() {
        return name;
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String value) {
        name.postValue(value);
    }

    public void onClick() {
        name.postValue("Hello" + CLICKED_COUNT++);
    }
}
