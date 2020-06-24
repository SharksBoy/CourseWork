package Tarakanoff.corp.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<String> mUrl;

    public NewsViewModel() {
        mUrl = new MutableLiveData<>();
        mUrl.setValue("https://tksu.ru/students/life/news/");
    }

    public LiveData<String> loadUrl() {
        return mUrl;
    }
}