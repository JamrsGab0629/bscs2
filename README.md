# create table
```sql
CREATE DATABASE school;

USE school;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    age INT NOT NULL,
    grades INT NOT NULL
);
```

### Download intellij

### download jbtc

### extract it 

### and add in project structures

```bash


# pansamantalang run
complie
javac --module-path "C:\Program Files\openjfx-25.0.2_windows-x64_bin-sdk\javafx-sdk-25.0.2\lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics -d . Main/Users/*.java Main/IO/Data/*.java Main/Prerequisite/List/*.java Gui/Login.java Gui/AdminDashboard.java Gui/Dashboard.java Gui/Register.java Bootstrap.java

run this to make the admin account
java Bootstrap

run now
java --module-path "C:\Program Files\openjfx-25.0.2_windows-x64_bin-sdk\javafx-sdk-25.0.2\lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics Gui.Login

# Compile
javac --module-path "[Path_to_JavaFX_lib]" --add-modules javafx.controls,javafx.fxml Main.java

# Run
java --module-path "[Path_to_JavaFX_lib]" --add-modules javafx.controls,javafx.fxml Main

# Remove all classes
Get-ChildItem -Recurse -Filter *.class | Remove-Item
```
