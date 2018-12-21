package com.example.yoggy.myoggu_latihan_gabungan1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;

public class FavoritFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_favorit, container, false);

        MaterialCalendarView materialCalendarView = (MaterialCalendarView)rootView.findViewById(R.id.calendarView);
              materialCalendarView.state().edit()
                      .setFirstDayOfWeek(Calendar.WEDNESDAY)
                       .setMinimumDate(CalendarDay.from(2018, 1, 1))
                       .setMaximumDate(CalendarDay.from(2019, 2, 1))
                       .setCalendarDisplayMode(CalendarMode.MONTHS)
                       .commit();

//        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
//       @Override
//       public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
//            Toast.makeText(FavoritFragment.instantiate())
//        }
//   });
          return rootView;
  }
}
