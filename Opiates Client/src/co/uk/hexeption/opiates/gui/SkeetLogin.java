package co.uk.hexeption.opiates.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import co.uk.hexeption.opiates.utils.GuiPasswordField;
import co.uk.hexeption.opiates.utils.LoginUtils;
import co.uk.hexeption.opiates.wrapper.Wrapper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

public class SkeetLogin extends GuiScreen {

	public GuiTextField usernameField;
	public GuiPasswordField passwordField;

	public GuiTextField curField;

	public GuiButton loginButton;
	public GuiButton editUserButton;
	public GuiButton editPassButton;
	public GuiScreen parentGui;

	public SkeetLogin(GuiScreen parent){
		this.parentGui = parent;
	}

	@Override
	public void initGui(){
		Keyboard.enableRepeatEvents(true);

		usernameField = new GuiTextField(0, Wrapper.getInstance().getMinecraft().fontRendererObj, (this.width / 2 - 55), (this.height / 2 - 26), 110, 20);
		passwordField = new GuiPasswordField(Wrapper.getInstance().getMinecraft().fontRendererObj, (this.width / 2 - 55), (this.height / 2 + 10), 110, 20);

		usernameField.setMaxStringLength(1000);
		passwordField.func_146203_f(1000);
		
		usernameField.setCanLoseFocus(true);
		passwordField.func_146205_d(true);

		loginButton = new GuiButton(0, (this.width / 2) - ((Wrapper.getInstance().getMinecraft().fontRendererObj.getStringWidth("Login") + 10) / 2), (this.height / 2) + 35, (Wrapper.getInstance().getMinecraft().fontRendererObj.getStringWidth("Login") + 10), 20, "Login");

		loginButton.enabled = true;

		this.buttonList.add(loginButton);
	}

	@Override
	public void updateScreen(){
		usernameField.updateCursorCounter();
		passwordField.updateCursorCounter();
	}

	@Override
	public void drawScreen(int x, int y, float ticks){
		this.drawDefaultBackground();

		drawString(Wrapper.getInstance().getMinecraft().fontRendererObj, "Username", (this.width / 2 - 55), (this.height / 2 - 36), 0xFFFFFF);
		drawString(Wrapper.getInstance().getMinecraft().fontRendererObj, "Password", (this.width / 2 - 55), (this.height / 2 - 4), 0xFFFFFF);
		usernameField.drawTextBox();
		passwordField.drawTextBox();

		loginButton.drawButton(Wrapper.getInstance().getMinecraft(), 1, 1);
		super.drawScreen(x, y, ticks);
	}

	@Override
	public void keyTyped(char keyChar, int keyCode){
		if(keyCode == 1){
			Wrapper.getInstance().getMinecraft().displayGuiScreen(parentGui);
		}else if(keyCode == 28){
			LoginUtils.login(usernameField.getText(), passwordField.getText());
			Wrapper.getInstance().getMinecraft().displayGuiScreen(parentGui);
		}else{
			this.usernameField.textboxKeyTyped(keyChar, keyCode);
			this.passwordField.textboxKeyTyped(keyChar, keyCode);
		}
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException{
		if(button.id == loginButton.id){
			LoginUtils.login(usernameField.getText(), passwordField.getText());
			Wrapper.getInstance().getMinecraft().displayGuiScreen(parentGui);
		}
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException{
		this.usernameField.mouseClicked(mouseX, mouseY, mouseButton);
		this.passwordField.mouseClicked(mouseX, mouseY, mouseButton);

		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

}

