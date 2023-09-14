package ru.project.workaccounting.ui.reports

import android.view.*
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import org.osmdroid.util.GeoPoint
import ru.project.workaccounting.R
import ru.project.workaccounting.data.database.MyRoomManager
import ru.project.workaccounting.databinding.ReportItemTemplateBinding
import ru.project.workaccounting.domain.models.Report
import ru.project.workaccounting.domain.usecase.GetDateTimeUseCase
import ru.project.workaccounting.ui.create.MyCreateReportBottomFragment
import ru.project.workaccounting.ui.map.MapFragment
import ru.project.workaccounting.ui.update.MyUpdateReportBottomFragment
import ru.project.workaccounting.ui.work.MyWorkDialogFragment

class ReportsAdapter: ListAdapter<Report, ReportsAdapter.ViewHolder>(ReportDiffCallback()) {
    private val getDateTimeUseCase = GetDateTimeUseCase()
    lateinit var fragmentManager: FragmentManager
    val array = ArrayList<Report>()

    class ViewHolder(
        var item: ReportItemTemplateBinding,
        val fragmentManager: FragmentManager,
    ): RecyclerView.ViewHolder(item.root) {
         var db: MyRoomManager = Room.databaseBuilder(
            item.root.context,
            MyRoomManager::class.java,
            "database"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()



        fun bind(report: Report) {
            item.apply {
                idReport.text = report.id.toString()
                worker.text = report.worker
                datetime.text = report.datetime.toString()
                address.text = report.address

                getDataWorkButton.setOnClickListener {
                    MyWorkDialogFragment(report.work).show(fragmentManager, "myWorkDialogFragment")
                }
            }
        }

    }

    class ReportDiffCallback : DiffUtil.ItemCallback<Report>() {
        override fun areItemsTheSame(oldItem: Report, newItem: Report): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Report, newItem: Report): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            item = ReportItemTemplateBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            fragmentManager = fragmentManager
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(array[position])

        holder.item.updateReport.setOnClickListener {
            MyUpdateReportBottomFragment(array[position]).show(
                fragmentManager, "myUpdateReportBottomFragment"
            )
        }

        holder.item.deleteReport.setOnClickListener {
            holder.db.reportDAO().deleteReport(array[position])
        }
    }

    override fun getItemCount(): Int = array.size

    fun sortDataMonth(report: Array<Report>) {
        for (i in report) {
            if (i.datetime.idMonth == getDateTimeUseCase.execute().idMonth) {
                array.add(i)
            }
        }
    }

    fun sortDataYear(report: List<Report>) {
        for (i in report) {
            if (i.datetime.year == getDateTimeUseCase.execute().year) {
                array.add(i)
            }
        }
    }

    fun addReport(report: Array<Report>) {
        for (i in report) {
            array.add(i)
        }
    }
}
