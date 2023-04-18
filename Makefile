#export PATH_TO_FX=path/to/javafx-sdk-20/lib
#export PATH_TO_FX_MODS=path/to/javafx-jmods-20
run:
	javac --module-path $PATH_TO_FX_MODS -d mods/hellofx $(find src/ -name "*.java")
fx:
	javac --module-path $PATH_TO_FX -d mods/hellofx $(find src/ -name "*.java")
