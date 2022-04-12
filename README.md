# Mobil Test Otomasyonunda Appium:

![image](https://user-images.githubusercontent.com/48343735/162944612-df1126a2-ee44-472a-b7c8-110cf19747e1.png)


Appium, açık kaynaklı, bir web sürücü kullanarak Android ve IOS komut dosyalarını çalıştırmak, yerel uygulamaları, mobil web uygulamalarını ve hibrit uygulamaları test etmek için kullanılan platformlar arası test otomasyon aracıdır. Piyasa da en çok kullanılan test otomasyon framework’ ü diyebilirim. 
2013 yılında piyasaya beta olarak Dan Cuellar tarafından sürülmüş ve 2017 yılında da beta sürümünden çıkmıştır.
Amaç olarak, Mobil de Android ve IOS tarafında test yazılmasını sağlasa da artık masaüstü uygulamaların test süreçlerinde de kullanılmaktadır.

 ### Appium Felsefesi: 
Appium geliştirici ekibi yükselen bir yıldız olan bu framework için, 4 ana felsefe belirlemişler;

1.	Uygulamanızı otomatikleştirmek için yeniden derlemeniz veya herhangi bir şekilde değiştirmeniz gerekmez.
2.	Testlerinizi yazmak ve çalıştırmak için belirli bir dile veya çerçeveye kilitlenmemelisiniz.
3.	Mobil otomasyon çerçevesi, otomasyon API’leri söz konusu olduğunda tekerleği yeniden icat etmemelidir.
4.	Mobil otomasyon framework’ ü adında olduğu gibi, açık kaynaklı, özgür ruhlu ve pratik olmalıdır.

### Appium Mimarisi:

![image](https://user-images.githubusercontent.com/48343735/162944023-78438b59-4fdb-45b1-b892-3f9e76d262d4.png)


Appium, Rest API kulanan bir web sunucusudur. İstemci tarafından bağlantı bilgilerini alır, bu bağlantılara ait komutları dinler, bu komutları istenilen bir mobil uygulamada yürütür ve bu komutların sonucunu temsilen bir HTTP yanıtı döner.
Yukarıda bahsedilen maddeleri açıklarsak; ilk madde için ürün sahibi tarafından sağlanan otomasyon çerçevelerini kullanarak 1.maddeyi karşılıyoruz. Bu şekilde, uygulamanız için Appium’a özgü veya üçüncü taraf kodları veya çerçeveleri derlememiz gerekmez. Bu, gönderdiğiniz aynı uygulamayı test ettiğiniz anlamına gelir.

2 numaralı gereksinimi, uygulama sahibi tarafından sağlanan çerçeveleri tek bir API olan WebDriver API’sine sararak karşılamaktadır. WebDriver (diğer adıyla “Selenium WebDriver”) bir istemci-sunucu protokolü belirtir (JSON Kablo Protokolü olarak bilinir ). Bu istemci-sunucu mimarisi göz önüne alındığında, sunucuya uygun HTTP isteklerini göndermek için herhangi bir dilde yazılmış bir istemci kullanılabilir. Bu aynı zamanda istediğiniz test çalıştırıcısını ve test çerçevesini kullanmakta özgür olduğumuz anlamına gelir; istemci kütüphaneleri sadece HTTP istemcileridir ve kodumuza istediğimiz gibi karıştırılabilir. Diğer bir deyişle, Appium & WebDriver istemcileri teknik olarak “test çerçeveleri” değildir, “otomasyon kütüphaneleri” dir. Bu sayede, Test ortamımızı istediğimiz gibi yönetebiliriz.

Appium, 3. gereksinimi aynı şekilde karşılıyor: WebDriver, web tarayıcılarını otomatikleştirmek için fiili standart haline gelmiştir ve bir W3C çalışma taslağıdır. 

### Appium Mimari Olarak Nasıl Çalışır?

Appium, Rest API kulanan bir web sunucusudur. İstemci tarafından bağlantı bilgilerini alır, bu bağlantılara ait komutları dinler, bu komutları istenilen bir mobil uygulamada yürütür ve bu komutların sonucunu temsilen bir HTTP yanıtı döner.

![image](https://user-images.githubusercontent.com/48343735/162944347-79c79186-adef-40a7-8f88-bcd579e1d152.png)


Bir istemci/sunucu mimarisine sahip olmak birçok avantaj sağlar;
1.	Test kodlarını http istemcisi olan herhangi bir dilde yazabiliriz. Python ve java en popüler olanları) (Appium istemci kütüphaneleri olan diller)
2.	Sunucu, testlerimizin çalıştığından farklı bir makine de olabilir.
3.	Test kodu yazabilir ve komutları almak ve yorumlamak için bir bulut hizmetine güvenebiliriz.

## Appium Kurulumu ve Testi:

#### Appium Server ve Inspector Nasıl Başlatılır?

Appium da testlerimizi ya gerçek bir cihaz üzerinde ya da emulatör üzerinde çalıştıracağız. Bu 2 durum için appium sunucusunun adres bilgisini değiştirmek gerekiyor.

![image](https://user-images.githubusercontent.com/48343735/162944708-7c67b0cd-d72c-44bc-a350-c28087af2a34.png)

Sunucu adresi ayarları için “Advanced“ sekmesini tıklayalım ve Server Adresi default olarak “0.0.0.0” geldiğini göreceksiniz. Bu aslında gerçek bir cihaz üzerinde çalıştırdığımızda kalması gereken adres. Ancak biz makinemizde ki bir emulatör üzerinden çalıştıracağımız için bu Server Address alanını “127.0.0.1“ olarak değiştireceğiz. Ve ardından bir sorun oluştuğunda oturumu geçersiz kılmak için “Oturum Geçersiz Kılmaya İzin Ver” yani “Allow Session Override” alanını ve ardından “Start Server v1.12.1” e tıklıyoruz. 
Not:Şimdilik port adresini değiştirmemize gerek yok.

![image](https://user-images.githubusercontent.com/48343735/162944877-273aa046-d85f-44e7-82cb-3b6e1e51bb27.png)

Testlerini otomatize edeceğimiz uygulamamızın capabilities bilgilerini girmek için yukarıda gösterdiğim search ikonuna tıklamanız yeterli.

#### Emulatör ve Uygulamaya Ait Apk Kurulumu: 

Emülatör kurulumu için Android Studio ya ihiyacımız var.
Hızlıca indirilen exe için kurulum gerçekleştiriyoruz. Sonrasında Android Studio yu açıyoruz. Aşağıdaki gibi gelen ekranda Configure →SDK Manager tıklayınız.

![image](https://user-images.githubusercontent.com/48343735/162945211-9bb2cea3-ed85-4e49-9b93-4112d7faffe9.png)

Açılan ekranda bulanan Android SDK Location alanındaki path i daha önce java kurulumu sonrasında Envoirment Variables kısmına yaptığımız gibi ANDROID_HOME adında bir değişken oluşturup, bu path’i buraya ekliyoruz.

![image](https://user-images.githubusercontent.com/48343735/162945269-d73ebf67-613e-4cba-b018-f95ab5436e46.png)

Tekrar Android Studio Ekranına gelerek bu ekranda emülatörün Android API seviyesini (Sürüm) seçiyoruz.

![image](https://user-images.githubusercontent.com/48343735/162945335-c3cf96ea-cc80-45fb-af5d-7bc43053e837.png)

Ben Oreo API 26’yı seçtim. Sonrasında SDK Tools sekmesini seçin ve benim seçtiğim araçların yüklemesi için aynılarını işaretleyin. Ve “Tamam” a tıklayın.
Yükleme bittikten sonra tekrar Configure sonrasında AVD Manager seçin. Ve sonra Emülatör oluşturmak için Create Virtual Device a tıklayın.

![image](https://user-images.githubusercontent.com/48343735/162945413-1f398abd-4fd3-4e3d-9af7-2cc0e036a7aa.png)

Gelen ekranda istenilen cihaz türünü seçin ve Next ile devam edin. Sonraki adım da Android sürümünü ben Pie seçtim daha önce yüklediklerim arasında vardı. 

![image](https://user-images.githubusercontent.com/48343735/162945487-0a4f8da8-6e7e-41db-af63-b9766d00638e.png)

Sonra android cihazınızın ismini girebileceğiniz ekran gelecektir. İsmini değiştirip Finish’e tıklayın. Ve ardından gelen ekranda “Play”e tıklayarak emülatörünüzün açılamasını bekleyin.

![image](https://user-images.githubusercontent.com/48343735/162945550-024a165d-39fd-42a7-9dff-782ba8596e80.png)

Ve artık emülatörümüz kullanıma hazır... 😍😎

#### Appium İnspector Ayarları:

Server başladıktan sonra Appium Inspector üzerinden yukarıdaki gibi ayarları yapmalıyız. Buradaki “appPackage” ve “appActivity” uygulamamızın başlaması ve doğru çalışması için mutlaka yazılması gereken özelliklerdir. Bunlar doğrudan uygulamamız ve projemiz üzerinden alınabilecek değerlerdir. Bu ayarları da yaptıktan sonra “Start Session” butonu üzerinden Inspector’ımızı başlatabiliriz

![image](https://user-images.githubusercontent.com/48343735/162945809-e6ea7489-d47f-4f62-bd9b-457cc5b746bc.png)


1. https://en.wikipedia.org/wiki/Appium
2. https://mesutbeysulen.medium.com/mobil-test-otomasyonunda-appium-1-d72dd2d8dc86
3. https://appium.io/
4. https://developer.android.com/studio
5. https://github.com/appium/appium-inspector













 
