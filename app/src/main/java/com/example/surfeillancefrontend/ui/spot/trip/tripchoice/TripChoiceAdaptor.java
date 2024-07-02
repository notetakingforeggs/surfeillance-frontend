package com.example.surfeillancefrontend.ui.spot.trip.tripchoice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.databinding.TripItemBinding;
import com.example.surfeillancefrontend.model.data.Trip;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TripChoiceAdaptor extends RecyclerView.Adapter<TripChoiceAdaptor.TripViewHolder> {

    private List<Trip> tripList;
    private Context context;
    private RecyclerViewInterface recyclerViewInterface;

    public TripChoiceAdaptor(List<Trip> tripList, Context context, RecyclerViewInterface recyclerViewInterface) {
        this.tripList = tripList;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @NotNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.trip_item, viewGroup, false);
        return new TripViewHolder(TripItemBinding.bind(view), recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TripViewHolder tripViewHolder, int i) {
        Trip trip = tripList.get(i);
        tripViewHolder.binding.setTrip(trip);
        tripViewHolder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    class TripViewHolder extends RecyclerView.ViewHolder{

  private final TripItemBinding binding;

        public TripViewHolder(TripItemBinding binding, RecyclerViewInterface recyclerViewInterface){
            super(binding.getRoot());
            this.binding = binding;
        }

    }

}
