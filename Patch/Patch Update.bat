@echo off



set mc-dir="C:\Users\Hexeption\Desktop\Hacked Clients\Workspace\Opiates Minecraft 1.9.X"
set opiates-dir="C:\Users\Hexeption\Desktop\Hacked Clients\Opiates"

cd %mc-dir%

git diff master > %opiates-dir%/Patch/Minecraft.patch

pause