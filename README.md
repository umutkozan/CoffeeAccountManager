MERNİS SERVİCE ADAPTER PROJECT

Bu proje, bir müşteri doğrulama sistemi sunmaktadır. Proje, müşterilerin kimlik bilgilerini doğrulamak için Türkiye Cumhuriyeti Kimlik Paylaşım Sistemi'ni (Mernis) kullanır.

Proje Yapısı
Proje aşağıdaki ana bileşenlerden oluşur:

Adapters.MernisServiceAdapter: Mernis servisi üzerinden kimlik doğrulama işlemlerini gerçekleştiren adapter sınıfıdır.
Soyutlar.ICustomerCheckService: Müşteri kimlik doğrulama servisinin arayüzünü tanımlar.
Soyutlar.BaseCustomerManager: Müşteri verilerini kaydetmek için temel iş mantığını sağlayan soyut sınıftır.
Soyutlar.ICustomerService: Müşteri servisi arayüzünü tanımlar.
Soyutlar.IVarliklar: Projedeki varlıkların arayüzünü tanımlar.
Varliklar.Customer: Müşteri bilgilerini tutan sınıftır.
Kullanım
1. MernisServiceAdapter
MernisServiceAdapter, ICustomerCheckService arayüzünü uygular ve Mernis servisi ile kimlik doğrulaması yapar.

java
Kodu kopyala
public class MernisServiceAdapter implements ICustomerCheckService {
    @Override
    public boolean CheckIfRealPerson(Customer customer) throws RemoteException {
        KPSPublicSoapProxy client = new KPSPublicSoapProxy();
        return client.TCKimlikNoDogrula(customer.NationalityId, 
                                        customer.FirstName.toUpperCase(),
                                        customer.LastName.toUpperCase(),    
                                        customer.dateOfBirth.getYear());
    }
}
2. BaseCustomerManager
BaseCustomerManager, müşteri verilerini kaydetmek için temel bir sınıftır.

java
Kodu kopyala
public abstract class BaseCustomerManager implements ICustomerService {
    public void Save(Customer customer) throws Exception {
        System.out.println("Veritabanına kaydedildi.");
    }
}
3. ICustomerCheckService
ICustomerCheckService, müşteri kimlik doğrulama işlemlerini tanımlayan bir arayüzdür.

java
Kodu kopyala
public interface ICustomerCheckService {
    boolean CheckIfRealPerson(Customer customer) throws RemoteException;
}
4. ICustomerService
ICustomerService, müşteri hizmetlerini tanımlayan bir arayüzdür.

java
Kodu kopyala
public interface ICustomerService {
    void Save(Customer customer) throws Exception;
}
5. IVarliklar
IVarliklar, projedeki varlıkların arayüzünü tanımlar.

java
Kodu kopyala
public interface IVarliklar {
}
6. Customer
Customer, müşteri bilgilerini tutan bir sınıftır.

java
Kodu kopyala
public class Customer implements IVarliklar {
    public int id;
    public String FirstName;
    public String LastName;
    public LocalDate dateOfBirth;
    public long NationalityId;
}
Gereksinimler
Java 8 veya üstü
Mernis servisine erişim için gerekli kütüphaneler (KPSPublicSoapProxy)
Kurulum
Bu projeyi klonlayın:
bash
Kodu kopyala
git clone https://github.com/umutkozan/mernis-service-adapter.git
Projeyi favori IDE'nizde açın.
Gereken bağımlılıkları ekleyin ve projeyi çalıştırın.
Katkıda Bulunma
Katkıda bulunmak için lütfen bir pull request gönderin veya bir issue açın.

Lisans
Bu proje MIT lisansı altında lisanslanmıştır. Daha fazla bilgi için LICENSE dosyasını inceleyin.

Bu README dosyası projenizin işlevselliğini ve kullanımını özetlemektedir. Daha fazla detay eklemek isterseniz, bu yapıyı genişletebilirsiniz.
