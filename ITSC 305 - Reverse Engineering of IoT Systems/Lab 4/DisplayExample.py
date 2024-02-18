
import I2C_LCD_driver as lcd_d

mylcd = lcd_d.lcd()
print("clear:")
mylcd.lcd_clear()
print("Hello")
mylcd.lcd_display_string("Hello")