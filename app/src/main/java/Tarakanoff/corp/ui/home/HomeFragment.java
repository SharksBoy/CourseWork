package Tarakanoff.corp.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Tarakanoff.corp.MainActivity2;
import Tarakanoff.corp.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);




        //Button all_std = root.findViewById(R.id.all_std);
        //Button all_tch = root.findViewById(R.id.all_tch);




        return root;
    }


    public static class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumbersViewHolder> {

        Button all_std = root.findViewById(R.id.all_std);
        Button all_tch = root.findViewById(R.id.all_tch);

        public int numberItems;

        public Context parent;

        public NumbersAdapter(int numberOfItems, Context parent) {

            numberItems = numberOfItems;

            this.parent = parent;
        }

        @NonNull
        @Override
        public NumbersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            int layoutIdForListItem = R.layout.number_list_item;

            LayoutInflater inflater = LayoutInflater.from(context);

            View view = inflater.inflate(layoutIdForListItem, parent, false);

            NumbersViewHolder viewHolder = new NumbersViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull NumbersViewHolder holder, int position) {



            all_std.setOnClickListener(v -> holder.bind("туть"));
            all_tch.setOnClickListener(v -> holder.bind("туть"));


    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class NumbersViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public NumbersViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_view_holder_number);
        }

        void bind(String listBd) {
            textView.setText(listBd);
        }
    }
}
}

