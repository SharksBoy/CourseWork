package Tarakanoff.corp.ui.notifications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.Objects;

import Tarakanoff.corp.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(this.requireContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(this.requireContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(this.requireContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        notificationsViewModel = ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        Button siteTksuBtn = root.findViewById(R.id.site_tksu);
        Button siteMoodleBtn = root.findViewById(R.id.site_moodle);
        Button siteOutlookBtn = root.findViewById(R.id.site_outlook);
        Button mapsTksuBtn = root.findViewById(R.id.maps);
        Button telephoneTksuBtn = root.findViewById(R.id.telephone_tksu);

        siteTksuBtn.setOnClickListener(v -> {
            openWebPage("https://tksu.ru/");
        });

        siteMoodleBtn.setOnClickListener(v -> openWebPage("https://moodle.tksu.ru/"));
        siteOutlookBtn.setOnClickListener(v -> openWebPage("https://outlook.office.com/"));
        mapsTksuBtn.setOnClickListener(v -> showMap(Uri.parse("geo:54.509661,36.274092?q=KGU+im+Tsiolkovskogo")));
        telephoneTksuBtn.setOnClickListener(v -> dialPhoneNumber("8 (4842) 57-61-20 "));


        return root;
    }
}