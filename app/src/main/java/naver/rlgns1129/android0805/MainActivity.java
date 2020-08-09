package naver.rlgns1129.android0805;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout swipeLayout;
    //ListView 나 RecyclerView의 데이터를 업데이트 할 의도가 있는 경우
    //Adapter 와 데이터는 인스턴스 변수로 같이 선언
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터 생성
        arrayList = new ArrayList<>();
        arrayList.add("java.lang");
        arrayList.add("java.util");
        arrayList.add("java.io");
        arrayList.add("java.net");

        //보통 리스트 생성 후 어답터를 생성
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        //ListView 에 설정
        //최근의 안드로이드 스튜디오에서는 강제 형 변환을 하지 않아도 됩니다.
        //코드 최적화를 이용해서 안드로이드 스튜디오가 자동 형 변환을 수행
        listView = findViewById(R.id.listView);
        //ListView에 설정
        listView.setAdapter(arrayAdapter);

        swipeLayout = findViewById(R.id.swipeLayout);

        //아래로 swipe 했을 때를 처리하는 리스너를 연결
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            //아래로 스와이프 했을 때 호출되는 메소드
            @Override
            public void onRefresh() {
                //데이터를 업데이트하고 ListView 나 RecyclerView를 업데이트
                //if(arrayList.contains("java.sql") == false) {} 이것은 내가 혼자 해본 것.
                if(arrayList.contains("java.sql") == false) {
                    arrayList.add(0, "패키지의 개념");
                    arrayList.add("java.sql");
                }
                //업데이트
                arrayAdapter.notifyDataSetChanged();
                //RefreshView를 화면에서 제거
                swipeLayout.setRefreshing(false);
            }
        });
    }

    //버튼의 클릭 이벤트 처리를 위하는 메소드
    public void click(View view){
        //방송을 송신
        Intent intent = new Intent();
        intent.setAction("naver.rlgns1129.sendbroadcast");
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }
}