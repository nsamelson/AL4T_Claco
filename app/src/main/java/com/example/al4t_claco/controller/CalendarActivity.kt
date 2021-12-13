package com.example.al4t_claco.controller

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop
import androidx.drawerlayout.widget.DrawerLayout
import androidx.gridlayout.widget.GridLayout
import com.example.al4t_claco.ChangePassword
import com.example.al4t_claco.R
import com.example.al4t_claco.model.Calendar
import com.example.al4t_claco.model.Classroom
import com.example.al4t_claco.model.Event
import com.example.al4t_claco.model.sessionManager
import com.google.android.material.navigation.NavigationView
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


class CalendarActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var session: sessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        session = sessionManager(applicationContext)
        session.checkLogin()

        supportActionBar?.title = "Calendar"

        //SIDE MENU

        val drawerLayout: DrawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout
        val navView: NavigationView = findViewById<View>(R.id.navView) as NavigationView
        val headerView = navView.getHeaderView(0)
        val user = headerView.findViewById<TextView>(R.id.user)

        var utilisateur: HashMap<String, String> = session.getUserDetails()
        var name :String = utilisateur.get(sessionManager.companion.KEY_NAME)!!

        user.text = name

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> startActivity(Intent(this, Dashboard::class.java))
                R.id.nav_calendar -> startActivity(Intent(this, CalendarActivity::class.java))
                R.id.nav_forum -> Toast.makeText(applicationContext, "Clicked Forum", Toast.LENGTH_SHORT).show()
                R.id.password -> startActivity(Intent(applicationContext, ChangePassword::class.java))
                R.id.logout -> session.logoutdUser()
            }
            true
        }

        //CREATE EVENTS

        val date1 = LocalDateTime.of(2021, 12, 13, 8, 30)
        val date2 = LocalDateTime.of(2021, 12, 13, 12, 0)

        val date3 = LocalDateTime.of(2021, 12, 17, 8, 30)
        val date4 = LocalDateTime.of(2021, 12, 17, 12, 0)

        val date5 = LocalDateTime.of(2021, 12, 17, 12, 45)
        val date6 = LocalDateTime.of(2021, 12, 17, 14, 0)

        val date9 = LocalDateTime.of(2021, 12, 15, 12, 45)
        val date10 = LocalDateTime.of(2021, 12, 15, 16, 0)

        val date7 = LocalDateTime.of(2021, 12, 15, 8, 30)
        val date8 = LocalDateTime.of(2021, 12, 15, 12, 0)

        val event1 = Event("SA4L-L1-4MIN", Classroom("1E06"), date1, date2, "Programmation parallèle  OpenGL\nGroupe : 4MIN\nEns : LUR")
        val event2 = Event("DD4L-L1-4MIN", Classroom("1G01"), date3, date4, "Labo architecture et qualité logicielle\nGroupe : 4MIN\nEns : J3L")
        val event3 = Event("AL4T-T1-4MIN", Classroom("1G01"), date5, date6, "architecture et qualité logicielle\nGroupe : 4MIN\nEns : J3L")
        val event4 = Event("SI4C-L1-4MIN", Classroom("1F04"), date7, date8, "Labo instrumentation\nGroupe : 4MIN\nEns : MCH, MDM")
        val event5 = Event("OS4T-T1-4MEO-4MIN", Classroom("1G01"), date9, date10, "Systèmes d'exploitation\nGroupe: 4MIN\nEns : HSL, XEI")
        val calendar = Calendar(listOf(event1, event2, event3, event4, event5))

        //POPUP OF THE EVENT

        fun showEventDialog(event: Event) {
            val dateShow = event.startDate.toLocalDate()
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))
                .split(",").slice(0..1).joinToString(",")
            val dateshowText = dateShow + " @ " + event.startDate.toLocalTime() + " - " + event.endDate.toLocalTime()
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setTitle(event.name)
            dialogBuilder.setMessage("${dateshowText}\n\nLoc : ${event.location.name} \n\nDesc : ${event.description}")
            dialogBuilder.setPositiveButton(R.string.close,
                DialogInterface.OnClickListener { dialog, whichButton ->

                })
            val b = dialogBuilder.create()
            b.show()
        }

        //ADD DAY TEXTVIEW

        fun createTextView(date: LocalDate, isToday: Boolean = false): TextView {
            val dateText = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)).split(",")
            val formatted = dateText[0] + "\n" + dateText[1].split(" ")[2]

            val dayText = TextView(this)
            dayText.text = formatted

            dayText.width = 280
            dayText.height = 180
            dayText.setGravity(Gravity.CENTER)

            if (isToday) {
                dayText.background = getDrawable(R.drawable.rounded_corner)
            }
            return dayText
        }

        //SHOW TIME POSITION BETWEEN THE EVENTS

        fun createHorizontalBar(): View {
            val marker = View(this)

            marker.setBackgroundColor(getColor(R.color.teal_200))
            marker.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                10
            )
            return marker
        }

        //ADD ALL EVENTS IN THE CALENDAR

        fun showEvents(events: MutableMap<LocalDate, MutableList<Event>>) {
            val gridlayout = findViewById<GridLayout>(R.id.gridCalendar)

            val today = LocalDateTime.now()
            val sorted = events.toSortedMap()
            var todayIsInEvents = true

            //if no event for the day
            val days = (events.keys.toMutableList() + today.toLocalDate()).sorted()
            val indexOfTodayDay = days.indexOf(today.toLocalDate())
            if (!sorted.containsKey(today.toLocalDate())) {
                todayIsInEvents = false
            }

            //iterate through all the days when there is an event
            for ((key, value) in sorted) {
                //TODO: change color maybe??

                if(!todayIsInEvents ){
                    if(indexOfTodayDay == (days.indexOf(key)-1)){
                        gridlayout.addView(createTextView(today.toLocalDate(), true))

                        //Add info that there is nothing planned for the day
                        val otherText = TextView(this)
                        otherText.text = "Nothing planned for the day."

                        otherText.width = 1000
                        otherText.height = 80
                        otherText.setPadding(30, 0, 0, 0)
                        otherText.gravity = Gravity.LEFT
                        gridlayout.addView(otherText)
                    }

                }

                //create day TextView
                if (today.toLocalDate() == key) {
                    gridlayout.addView(createTextView(key, true))
                } else {
                    gridlayout.addView(createTextView(key))
                }


                //create gridlayout for events of the day

                val dayEvents = GridLayout(this)
                dayEvents.columnCount = 1

                val gridParams = RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT
                )
                dayEvents.layoutParams = gridParams
                dayEvents.setPadding(8, 0, 280, 0)

                //create buttons

                val times = value.toMutableList().map { it.endDate } + today
                val sortedTimes = times.sorted()
                val indexOfTodayTime = sortedTimes.indexOf(today)

                val sortedEvents = value.sortedBy { it.startDate }

                for (event in sortedEvents) {

                    //add horizontal line before event
                    if (today.toLocalDate() == key) {
                        val indexOfEvent = sortedEvents.indexOf(event)
                        if (indexOfEvent == indexOfTodayTime) {
                            if(todayIsInEvents){
                                dayEvents.addView(createHorizontalBar())
                            }

                        }
                    }

                    //add event button

                    val buttonEvent = Button(this, null, android.R.attr.buttonStyle)
                    val eventText =
                        event.name + "\n" + event.startDate.toLocalTime() + " - " + event.endDate.toLocalTime()
                    buttonEvent.text = eventText
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


                    buttonEvent.setOnClickListener(View.OnClickListener {
                        Toast.makeText(applicationContext, "clicked on ${event.name}", Toast.LENGTH_SHORT).show()
                        showEventDialog(event)
                    })

                    dayEvents.addView(buttonEvent)

                }

                //add horizontal line after event if end of the day
                if (today.toLocalDate() == key) {
                    if (sortedTimes.last() == today) {
                        if(todayIsInEvents){
                            dayEvents.addView(createHorizontalBar())
                        }
                    }
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
        showEvents(calendar.eventsPerDay)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search, menu)
        val menuItem = menu?.findItem(R.id.action_search)
        val searchView = menuItem?.actionView
        val text: String = "Search"
        searchView?.setAutofillHints("Search date")

        return true
    }

}