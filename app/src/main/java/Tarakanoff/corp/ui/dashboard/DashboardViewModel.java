package Tarakanoff.corp.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mUrl;

    public DashboardViewModel() {
        mUrl = new MutableLiveData<>();
        mUrl.setValue("https://tksu.ru/students/raspisanie-zanyatiy/");
    }

    public LiveData<String> loadUrl() {
        return mUrl;
    }
}