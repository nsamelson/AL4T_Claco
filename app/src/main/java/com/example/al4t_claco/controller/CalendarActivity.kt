package com.example.al4t_claco.controller

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout
import com.example.al4t_claco.R
import com.example.al4t_claco.model.Calendar
import com.example.al4t_claco.model.Classroom
import com.example.al4t_claco.model.Event
import java.sql.Date


class CalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)


        val date1 = Date(1629161352048)
        val date2 = Date(1639131352048)
        val date3 = Date(1639961352048)
        val date4 = Date(1649151352048)

        val event1 = Event("cours 1", Classroom("Ecam"),date1,"Ceci est une description")
        val event2 = Event("cours 2", Classroom("Teams"),date2,"Ceci est une autre description")
        val event3 = Event("cours 3", Classroom("XOXO"),date3,"Ceci est encore une description")
        val event4 = Event("cours 4", Classroom("Ecam"),date4,"Ceci est hihi une description")
        val event5 = Event("cours 5", Classroom("Ecam"),date1,"Ceci est une énORME description")

        val calendar = Calendar(listOf(event1,event2,event3,event4,event5))

        fun showEventDialog(event: Event){
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setTitle("Do you want to download the following file?")
            dialogBuilder.setMessage("Name : ${event.name}\nType : ${event.descrition}")
            dialogBuilder.setPositiveButton(R.string.close,
                DialogInterface.OnClickListener { dialog, whichButton ->

                })
        }

        fun showEvents(events: Map<String, Event>){
            val gridlayout = findViewById<GridLayout>(R.id.gridCalendar)

            for((key, value)  in events){
                //TODO: properly handle dates, redo the map because it's not a map of String,List(Event)
                //TODO: change color maybe??

                //create day TextView

                val dayText = TextView(this)
                dayText.text = key
                dayText.maxWidth = 280
                gridlayout.addView(dayText)

                //create gridlayout for events of the day

                val dayEvents = GridLayout(this)
                dayEvents.columnCount = 1

                val gridParams= RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT
                )
                dayEvents.layoutParams = gridParams
                dayEvents.setPadding(8,0,280,0)

                //create buttons
                for(i in 1..4){
                    val buttonEvent = Button(this,null, android.R.attr.buttonStyle)
                    buttonEvent.text = i.toString()
                    buttonEvent.isAllCaps = false
                    //buttonEvent.width = R.dimen.event_width //not working for some reason
                    buttonEvent.backgroundTintList = getColorStateList(R.color.button_color)
                    buttonEvent.setTextColor(getColor(R.color.white))

                    val buttonParams = RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                    )
                    buttonParams.setMargins(0, 0, 0, 0)
                    buttonEvent.layoutParams = buttonParams
                    buttonEvent.text = value.name



                    buttonEvent.setOnClickListener(View.OnClickListener {
                        Toast.makeText(applicationContext,"clicked on ${i}", Toast.LENGTH_SHORT).show()
                        //TODO: showEventDialog(event)
                    })

                    dayEvents.addView(buttonEvent)

                }

                //add space after the buttons
                val space = Space(this)
                val spaceParams = RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    80
                ) //R.dimen.event_space_height doesn't work for some reason
                space.layoutParams = spaceParams
                dayEvents.addView(space)


                gridlayout.addView(dayEvents)
            }








        }
        showEvents(calendar.eventPerDay)

    }


}
