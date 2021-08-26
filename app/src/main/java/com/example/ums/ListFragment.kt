package com.example.ums


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ums.Adapter.*
import com.example.ums.Models.*
import com.example.ums.Utils.MyData
import kotlinx.android.synthetic.main.fragment_list.view.*

class MinutesFragment : Fragment() {

    lateinit var adapteroylik: InternetAdapter
    lateinit var adapterkunlik: InternetAdapter
    lateinit var adapternews: NewsAdapter
    lateinit var adapterSms: SmsAdapter
    lateinit var listoylik: ArrayList<InternetModel>
    lateinit var listNews: ArrayList<NewsModel>
    lateinit var listSms: ArrayList<SmsModel>
    lateinit var root: View
    lateinit var list: ArrayList<MinutesModel>
    lateinit var list2: ArrayList<TarifModel>
    lateinit var adapter: MinutesAdapter
    lateinit var adapter2: TariffsAdapter
    lateinit var list3 : ArrayList<ServicesModel>
    lateinit var adapter3: ServicesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        root = inflater.inflate(R.layout.fragment_list, container, false)

        when (MyData.number) {

            "1" -> {

                list2 = ArrayList()

                list2.add(TarifModel("Mobi 20", "*111*120#", "20000/1000 sum monthly"))
                list2.add(TarifModel("Mobi 30", "*111*128#", "30000/1000 sum monthly"))
                list2.add(TarifModel("Mobi 40", "*111*121#", "40000/1000 sum monthly"))

                adapter2 = TariffsAdapter(root.context, list2)

                root.minutesRecyclerView.adapter = adapter2

            }

            "2" -> {
                list = ArrayList()
                list.add(MinutesModel("20 minutes", "#123*112", "20000 sum"))
                list.add(MinutesModel("30 minutes", "#123*113", "30000 sum"))
                list.add(MinutesModel("40 minutes", "#123*114", "40000 sum"))
                list.add(MinutesModel("50 minutes", "#123*115", "50000 sum"))

                adapter = MinutesAdapter(root.context, list)

                root.minutesRecyclerView.adapter = adapter

            }

            "3" -> {
                listoylik = ArrayList()

                listoylik.add(InternetModel("300 mb", "8000 sum", "30 day", "*171*019*1*010300368*1#"))
                listoylik.add(InternetModel("500 mb", "9000 sum", "30 day", "*171*019*7*010300368*1#"))
                listoylik.add(InternetModel("1000 mb", "11000 sum", "30 day", "*171*019*2*010300368*1#"))
                listoylik.add(InternetModel("2000 mb", "17000 sum", "30 day", "*171*019*5*010300368*1#"))
                listoylik.add(InternetModel("3000 mb", "25000 sum", "30 day", "*171*019*3*010300368*1#"))
                listoylik.add(InternetModel("5000 mb", "33000 sum", "30 day", "*171*019*4*010300368*1#"))
                listoylik.add(InternetModel("10000 mb", "50000 sum", "30 day", "*171*019*6*010300368*1#"))
                listoylik.add(InternetModel("20000 mb", "55000 sum", "30 day", "*171*019*8*010300368*1#"))
                listoylik.add(InternetModel("30000 mb", "65000 sum", "30 day", "*171*019*9*010300368*1#"))
                listoylik.add(InternetModel("50000 mb", "75000 sum", "30 day", "*171*019*10*010300368*1#"))
                listoylik.add(InternetModel("200 mb", "2000 sum", "1 day", "*171*204*200*010300368*1#"))
                listoylik.add(InternetModel("300 mb", "3000 sum", "1 day", "*171*204*300*010300368*1#"))
                listoylik.add(InternetModel("500 mb", "4000 sum", "1 day", "*171*204*500*010300368*1#"))
                listoylik.add(InternetModel("1000 mb", "5000 sum", "1 day", "*171*204*1000*010300368*1#"))
                listoylik.add(InternetModel("2000 mb", "9000 sum", "1 day", "*171*204*2000*010300368*1#"))
                listoylik.add(InternetModel("3000 mb", "12000 sum", "1 day", "*171*204*3000*010300368*1#"))
                listoylik.add(InternetModel("5000 mb", "16500 sum", "1 day", "*171*204*5000*010300368*1#"))
                listoylik.add(InternetModel("10000 mb", "16500 sum", "1 day", "*171*204*1000*010300368*1#"))

                adapteroylik = InternetAdapter(root.context, listoylik, object : ItemClick2 {
                    override fun onClick(list: ArrayList<InternetModel>, position: Int) {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:${list[position].cod}")
                        startActivity(intent)
                    }

                })
                root.minutesRecyclerView.adapter = adapteroylik
            }

            "4" -> {
                list3 = ArrayList()

                list3.add(ServicesModel("Check the balance and limits of tariffs plan", "*100#"))
                list3.add(ServicesModel("Check the remainder of all internet packs", "*102#"))
                list3.add(ServicesModel("Check internet packs with bonuses", "*102*0#"))
                list3.add(ServicesModel("Check the remainder of minutes", "*103#"))
                list3.add(ServicesModel("Check minute packs with bonuses", "*103*0#"))
                list3.add(ServicesModel("Check SMS packs packs", "*104#"))
                list3.add(ServicesModel("Check SMS packs with bonuses", "*104*0#"))
                list3.add(ServicesModel("Portal for turning services on and off", "*111#"))

                adapter3 = ServicesAdapter(root.context, list3, object : ItemClick4 {
                    override fun onClick(list: ArrayList<ServicesModel>, position: Int) {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:${list[position].code}")
                        startActivity(intent)
                    }
                })
                root.minutesRecyclerView.adapter = adapter3
            }

            "5" -> {
                listSms = ArrayList()
                listSms.add(SmsModel("«SMS 100»","*104*100#","4 500 sum"))
                listSms.add(SmsModel("«SMS 300»","*104*300#","10 500 sum"))

                adapterSms = SmsAdapter(listSms, object : ItemClick3 {
                    override fun onClick(list: ArrayList<SmsModel>, position: Int) {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:${list[position].code}")
                        startActivity(intent)
                    }
                })
                root.minutesRecyclerView.adapter = adapterSms
            }

            "6" -> {
                listNews = ArrayList()
                listNews.add(
                    NewsModel(
                        "Tariff plans for Mobi 20, 30 and 40 are updated!",
                        "https://corp.mobi.uz/ru/news/2021/23130/"
                    )
                )
                listNews.add(
                    NewsModel(
                        "Dear users! We are happy to announce that tariff plans for Mobi 20, Mobi 30, and Mobi 40, and Mobi 50 are updated. Feel free to enjoy new plans and get more benefit with us",
                        "https://corp.mobi.uz/ru/news/2021/22881/"
                    )
                )


                adapternews = NewsAdapter(listNews, object : ItemClick1 {
                    override fun onClick(list: ArrayList<NewsModel>, position: Int) {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(list[position].uri))
                        startActivity(intent)
                    }
                })

                root.minutesRecyclerView.adapter = adapternews
            }

        }
        return root
    }
}


