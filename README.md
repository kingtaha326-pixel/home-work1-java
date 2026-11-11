# Smart Box Storage System

> **Repository/content note:** This repository currently contains a Java smart-box storage demonstration, not a Payroll Management System. The requested payroll source files (`Employee.java`, `FullTimeEmployee.java`, `ContractorEmployee.java`, `Taxable.java`, `BonusCalculable.java`, and `PayrollSystem.java`) are not present in the repository. This README describes the source code that is actually present and does not infer payroll features that are not implemented.

## Project Description

This console application demonstrates Java generics through a simple storage-box scenario. A generic `SmartBox<T>` can store and display an object of a chosen type. The application lets the user create a medicine box or an electronics box, enter one item's details, and print the box information.

The project is suitable as a small introductory exercise in generic classes, object creation, console input, and overriding `toString()`.

## Objectives

- Demonstrate a generic class that can hold different object types.
- Model medicine and electronic-device items as separate classes.
- Collect data from the user with `Scanner`.
- Display stored item details through each object's `toString()` implementation.
- Provide a repeating menu that continues until the user chooses to exit.

## Technologies

- **Java** — source code uses generics, classes, constructors, and console I/O.
- **JDK:** The code uses language features available in Java 7 and later (including the diamond operator). A modern JDK is recommended.
- **NetBeans IDE** — can be used to open and run the project as a Java application.

## Project Structure

| File / class | Purpose |
|---|---|
| `DynamicSearch.java` | Contains all classes for the demonstration: `SmartBox<T>`, `Medicine`, `ElectronicDevice`, and the application entry point `ManualDailyLifeGenericApp`. |
| `SmartBox<T>` | Generic storage box with a name, a displayed maximum-weight value, and a slot for one item of type `T`. |
| `Medicine` | Stores a medicine name and expiry-date string; formats these values in `toString()`. |
| `ElectronicDevice` | Stores a device brand and warranty duration in months; formats these values in `toString()`. |
| `ManualDailyLifeGenericApp` | Contains `main`, the interactive menu, user input, object creation, and program exit handling. |

There are no separate payroll classes or interfaces in the current repository. The source also has no separate `Taxable`, `BonusCalculable`, or `Employee` types.

## How the Application Works

`SmartBox<T>` uses a type parameter `T` for its stored item. The application creates a `SmartBox<Medicine>` for medicine and a `SmartBox<ElectronicDevice>` for an electronic device. This allows the compiler to associate each box with the intended item type without requiring the program to cast the retrieved item.

`Medicine` and `ElectronicDevice` are independent classes; neither inherits from the other. Both override `toString()` so that `SmartBox.printBoxDetails()` can print their details using the common `Object.toString()` method.

The menu repeats inside a `while (true)` loop. Choosing option `3` prints a goodbye message and exits the loop. Other entered values are handled as invalid options.

## Important Implementation Details

- A box stores **one item**; calling `storeItem` assigns its item field.
- The maximum-weight value is printed as box information only. The current code does **not** store or measure item weight, compare an item against the limit, or reject an item based on weight.
- The expiry date and warranty are collected as strings/numbers and displayed. The source does not validate their format or business rules.
- The interactive menu offers options for medicine, electronics, and exit.

## Running the Program

The source declares `public class ManualDailyLifeGenericApp`, while the repository file is named `DynamicSearch.java`. Java requires a public top-level class to be in a file with the same name. Therefore, the source as currently named may not compile directly with `javac` or run as a standard NetBeans Java project.

To run it in a local working copy without changing this repository, first place the source in a file named `ManualDailyLifeGenericApp.java`, then:

1. Open NetBeans and create or open a Java application project.
2. Add `ManualDailyLifeGenericApp.java` to the project’s source package (or leave it in the default package, as in the current source).
3. Set `ManualDailyLifeGenericApp` as the main class if NetBeans does not detect it automatically.
4. Run the project and enter menu selections in the Output/console window.

Alternatively, compile and run from a terminal after the source file has the required filename:

```bash
javac ManualDailyLifeGenericApp.java
java ManualDailyLifeGenericApp
```

This README does not rename or modify any Java source file.

## Example Interaction

The following is an illustrative run using the prompts and output strings in the source. User-entered values are shown after the prompts. The messages themselves are printed in Arabic by the application.

```text
=== نظام تخزين الصناديق الذكية (Generics) ===

اختر نوع الصندوق الذي تريد إنشاءه:
1. صندوق أدوية (Medicine Box)
2. صندوق إلكترونيات (Tech Box)
3. خروج من البرنامج (Exit)
الرجاء إدخال الخيار (1 أو 2 أو 3): 1
أدخل اسم الدواء: Paracetamol
أدخل تاريخ الصلاحية (مثال: 2028/12): 2028/12

[تم التخزين بنجاح] في الصندوق: صندوق الإسعافات الأولية

--- تفاصيل الصندوق ---
اسم الصندوق: صندوق الإسعافات الأولية | الحد الأقص للوزن: 2.5 كغ
المحتوى الداخلي: دواء [اسم الدواء: Paracetamol، تاريخ الصلاحية: 2028/12]
--------------------------------------------------

اختر نوع الصندوق الذي تريد إنشاءه:
1. صندوق أدوية (Medicine Box)
2. صندوق إلكترونيات (Tech Box)
3. خروج من البرنامج (Exit)
الرجاء إدخال الخيار (1 أو 2 أو 3): 3

شكراً لاستخدامك نظام الصناديق الذكية. مع السلامة!
```

The example follows the prompts and formatting present in the source. The actual displayed text is Arabic; item values vary according to user input.

## Java Concepts Demonstrated

- **Generic classes and type parameters:** `SmartBox<T>` can be parameterized with different item types.
- **Encapsulation:** class data is held in private fields and initialized through constructors.
- **Classes and objects:** medicine, electronic-device, and box instances are created at runtime.
- **Constructors:** initialize object state when instances are created.
- **Method overriding:** `Medicine` and `ElectronicDevice` override `toString()`.
- **Console input/output:** `Scanner` reads user choices and item details; `System.out` prints prompts and results.
- **Control flow:** a loop and conditional branches implement the menu and its options.
- **Null checking:** the box checks whether it contains an item before printing its details.

## Payroll Documentation Status

A Payroll Management System README describing tax rates, bonuses, employee types, or net-salary calculations cannot be written accurately from the current repository contents: none of the payroll source files listed in the request are present. Add or point to the intended payroll project/source files before documenting those rules.
