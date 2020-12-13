package com.maryna.photographer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.maryna.photographer.model.Photo;
import com.maryna.photographer.model.PhotoPackage;
import com.maryna.photographer.model.PhotoSession;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_portfolio)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        initializeDB();
    }

    private void initializeDB() {
        List<PhotoSession> photoSessions = new ArrayList<>();
        photoSessions.add(new PhotoSession(
                        getString(R.string.love_story),
                        "https://user-images.githubusercontent.com/66691210/102014745-4a70e700-3d60-11eb-99c0-00f721a6935c.jpg",
                        "Історія любові кожної пари неповторна! Я допоможу зберегти її у пам'яті назавжди.",
                        0
                )
        );
        photoSessions.add(new PhotoSession(
                        "Сімейна",
                        "https://user-images.githubusercontent.com/66691210/102014867-f0245600-3d60-11eb-8ff5-5a620fb3333d.jpg",
                        "Сімейна фотосесія – це весела зйомка, яка ще більше зблизить вашу сім'ю, а фото стануть чудовою прикрасою дому.",
                        1
                )
        );
        photoSessions.add(new PhotoSession(
                        "Дитяча",
                        "https://user-images.githubusercontent.com/66691210/102014959-55784700-3d61-11eb-9cd0-4d78cfbf4b7d.jpg",
                        "Сімейна фотосесія – це весела зйомка, яка ще більше зблизить вашу сім'ю, а фото стануть чудовою прикрасою дому.",
                        2
                )
        );
        photoSessions.add(new PhotoSession(
                        "Індивідуальна",
                        "https://user-images.githubusercontent.com/66691210/102015006-8a849980-3d61-11eb-8b40-a158ef254490.jpg",
                        "Індивідуальна фотосесії - це ваше особисте свято і привід глянути на себе з зовсім іншого боку, відкрити те, чого не помічали раніше.",
                        3
                )
        );

        List<PhotoPackage> photoPackages = new ArrayList<>();

        photoPackages.add(new PhotoPackage(
                        "Економ",
                        "Зйомка в студії, на природі чи в місті",
                        30,
                        8,
                        700
                )
        );

        photoPackages.add(new PhotoPackage(
                        "Оптимальний",
                        "Зйомка в студії, на природі чи в місті",
                        60,
                        15,
                        1100
                )
        );

        photoPackages.add(new PhotoPackage(
                        "Все включено",
                        "Зйомка в студії, на природі чи в місті",
                        90,
                        20,
                        2000
                )
        );

        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014745-4a70e700-3d60-11eb-99c0-00f721a6935c.jpg",
                        0
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014746-4ba21400-3d60-11eb-8db2-bf7db30def95.jpg",
                        0
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014747-4c3aaa80-3d60-11eb-8252-f52591a60ff5.jpg",
                        0
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014749-4c3aaa80-3d60-11eb-856e-cc8ba93888f9.jpg",
                        0
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014750-4cd34100-3d60-11eb-90bc-e0d5708c2053.jpg",
                        0
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014751-4cd34100-3d60-11eb-9788-8612625324e0.jpg",
                        0
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014752-4cd34100-3d60-11eb-8ece-a71d34373202.jpg",
                        0
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014753-4d6bd780-3d60-11eb-9629-546392691098.jpg",
                        0
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014867-f0245600-3d60-11eb-8ff5-5a620fb3333d.jpg",
                        1
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014868-f0bcec80-3d60-11eb-8db8-ad62e9554c84.jpg",
                        1
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014869-f1558300-3d60-11eb-8d22-811df9dd7227.jpg",
                        1
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014871-f1558300-3d60-11eb-8486-301bf6a7b974.jpg",
                        1
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014872-f1ee1980-3d60-11eb-9b3a-17dd9ec4ddbf.jpg",
                        1
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014873-f1ee1980-3d60-11eb-8009-480ee3c58978.jpg",
                        1
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014874-f1ee1980-3d60-11eb-911b-5992d1465da3.jpg",
                        1
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014876-f286b000-3d60-11eb-9a60-6df8f2d5351d.jpg",
                        1
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014959-55784700-3d61-11eb-9cd0-4d78cfbf4b7d.jpg",
                        2
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014963-5610dd80-3d61-11eb-8b5a-b039307792eb.jpg",
                        2
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014964-56a97400-3d61-11eb-8b89-2b45e863d5ff.jpg",
                        2
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014965-56a97400-3d61-11eb-8448-d5cae39dead9.jpg",
                        2
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014968-57420a80-3d61-11eb-9ee8-6805d9a0bdee.jpg",
                        2
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014969-57420a80-3d61-11eb-9139-e8783ff4d9e4.jpg",
                        2
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014970-57daa100-3d61-11eb-8c51-c29a928afb4e.jpg",
                        2
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102014971-57daa100-3d61-11eb-9926-a6911c0d1816.jpg",
                        2
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102015006-8a849980-3d61-11eb-8b40-a158ef254490.jpg",
                        3
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102015037-bbfd6500-3d61-11eb-9296-55597d6df213.jpg",
                        3
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102015039-bc95fb80-3d61-11eb-8fc8-bbfe74f2d184.jpg",
                        3
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102015040-bd2e9200-3d61-11eb-980f-cabd85e3db7e.jpg",
                        3
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102015041-bd2e9200-3d61-11eb-8da5-d6f744806830.jpg",
                        3
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102015043-bdc72880-3d61-11eb-84fe-88fcc00cbbbc.jpg",
                        3
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102015044-bdc72880-3d61-11eb-828c-2d2d67d3a013.jpg",
                        3
                )
        );

        photos.add(new Photo(
                        "https://user-images.githubusercontent.com/66691210/102015046-bdc72880-3d61-11eb-9eae-d8f3e33734fa.jpg",
                        3
                )
        );

        Completable.fromAction(() -> {
            App.getInstance().getDatabase().clearAllTables();

            App.getInstance().getDatabase().photoSessionDao().insertAllPhotoSessions(photoSessions);
            App.getInstance().getDatabase().photoPackageDao().insertAllPhotoPackages(photoPackages);
            App.getInstance().getDatabase().photoDao().insertAllPhotos(photos);
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                        }, error -> {
                        }
                );


    }

}