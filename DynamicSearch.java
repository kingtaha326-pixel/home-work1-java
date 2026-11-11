import java.util.Scanner;

// 1. تعريف صنف عام (Generic Class) يمثل صندوق تخزين ذكي
class SmartBox<T> {
    private String boxName;
    private T item;
    private double maxWeightKg;

    public SmartBox(String boxName, double maxWeightKg) {
        this.boxName = boxName;
        this.maxWeightKg = maxWeightKg;
    }

    public void storeItem(T item) {
        this.item = item;
        System.out.println("\n[تم التخزين بنجاح] في الصندوق: " + boxName);
    }

    public void printBoxDetails() {
        System.out.println("\n--- تفاصيل الصندوق ---");
        System.out.println("اسم الصندوق: " + boxName + " | الحد الأقص للوزن: " + maxWeightKg + " كغ");
        if (item != null) {
            System.out.println("المحتوى الداخلي: " + item.toString());
        } else {
            System.out.println("الصندوق فارغ حالياً.");
        }
        System.out.println("--------------------------------------------------");
    }
}

// أصناف تمثل الأشياء في الحياة اليومية
class Medicine {
    private String name;
    private String expiryDate;

    public Medicine(String name, String expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "دواء [اسم الدواء: " + name + "، تاريخ الصلاحية: " + expiryDate + "]";
    }
}

class ElectronicDevice {
    private String brand;
    private int warrantyMonths;

    public ElectronicDevice(String brand, int warrantyMonths) {
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String toString() {
        return "جهاز إلكتروني [الماركة: " + brand + "، الضمان: " + warrantyMonths + " أشهر]";
    }
}

// 2. الفئة الرئيسية مع حلقة تكرار لإدخال بيانات جديدة باستمرار
public class ManualDailyLifeGenericApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== نظام تخزين الصناديق الذكية (Generics) ===");

        // حلقة تكرار لا تنتهي إلا إذا اخترت الخروج (3)
        while (true) {
            System.out.println("\nاختر نوع الصندوق الذي تريد إنشاءه:");
            System.out.println("1. صندوق أدوية (Medicine Box)");
            System.out.println("2. صندوق إلكترونيات (Tech Box)");
            System.out.println("3. خروج من البرنامج (Exit)");
            System.out.print("الرجاء إدخال الخيار (1 أو 2 أو 3): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // لتنظيف السطر بعد قراءة الرقم

            if (choice == 1) {
                // إنشاء صندوق أدوية باستخدام Generics
                SmartBox<Medicine> pharmacyBox = new SmartBox<>("صندوق الإسعافات الأولية", 2.5);
                
                System.out.print("أدخل اسم الدواء: ");
                String medName = scanner.nextLine();
                
                System.out.print("أدخل تاريخ الصلاحية (مثال: 2028/12): ");
                String expiry = scanner.nextLine();

                Medicine med = new Medicine(medName, expiry);
                pharmacyBox.storeItem(med);
                pharmacyBox.printBoxDetails();

            } else if (choice == 2) {
                // إنشاء صندوق إلكترونيات باستخدام Generics
                SmartBox<ElectronicDevice> techBox = new SmartBox<>("خزنة الأدوات التقنية", 5.0);
                
                System.out.print("أدخل ماركة الجهاز الإلكتروني: ");
                String brandName = scanner.nextLine();
                
                System.out.print("أدخل فترة الضمان بالأشهر (مثال: 24): ");
                int warranty = scanner.nextInt();
                scanner.nextLine(); // لتنظيف السطر بعد قراءة الرقم

                ElectronicDevice device = new ElectronicDevice(brandName, warranty);
                techBox.storeItem(device);
                techBox.printBoxDetails();

            } else if (choice == 3) {
                // إيقاف الحلقة وإنهاء البرنامج
                System.out.println("\nشكراً لاستخدامك نظام الصناديق الذكية. مع السلامة!");
                break;
            } else {
                System.out.println("\n[خطأ] خيار غير صحيح! يرجى إدخال 1، 2، أو 3.");
            }
        }

        scanner.close();
    }
}
