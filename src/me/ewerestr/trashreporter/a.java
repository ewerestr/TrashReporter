package me.ewerestr.trashreporter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class a extends JavaPlugin implements Listener
{
	private int b;
	private int c;
	private File h;
	private char I_ = '7';
	private char i_ = '8';
	private char _i = '6';
	private YamlConfiguration i;
	private Map<UUID,Integer> _a = new HashMap<UUID,Integer>();
	private String[] l = new String[32];	
	public void onEnable()
	{
		_c();_l();
		getCommand("trashreporter").setExecutor(new e(this));
	}	
	public void onDisable()
	{
		try
		{	
			i.set("L", c);
			i.set("E", b);
			i.save(h);
		}
		catch (IOException X)
		{
			getLogger().info("Can't save config");
			X.printStackTrace();
		}	
	}
	private void _S()
	{
		char[] _a_ = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		if(i.getString("colorline1")!=null&&i.getString("colorline2")!=null&&i.getString("dtcolorline")!=null)
		{
			String s_ = i.getString("colorline1"), s__ = i.getString("colorline2"), s___ = i.getString("dtcolorline");
			if(s_.length()==1)
			{
				I_ = s_.toCharArray()[0];
			}
			else
			{
				char[] _pK = s_.toCharArray();
				for (int _v = 0; _v < s_.length(); _v++)
				{
					char _f = _pK[_v];
					for (char v_ : _a_)
					{
						if (_f == v_) I_ = _f;
					}
				}
			}
			if(s__.length()==1)
			{
				i_ = s__.toCharArray()[0];
			}
			else
			{
				char[] _b = s__.toCharArray();
				for (int e = 0; e < s__.length(); e++)
				{
					char zd = _b[e];
					for (char _v : _a_)
					{
						if (zd == _v) i_ = zd;
					}
				}
			}
			if(s___.length()==1)
			{
				_i = s___.toCharArray()[0];
			}
			else
			{
				char[] u = s___.toCharArray();
				for (int b = 0; b < s___.length(); b++)
				{
					char q = u[b];
					for (char g : _a_)
					{
						if (q == g) I_ = q;
					}
				}
			}
		}
	}
	private void _c()
	{
		h = new File(getDataFolder(), "config.yml");
		if (h.exists())
		{
			i = YamlConfiguration.loadConfiguration(h);
			b = i.getInt("E");
			c = i.getInt("L");
			_S();
		}
		else
		{
			i = YamlConfiguration.loadConfiguration(h);
			try
			{
				i.set("L", 0);
				i.set("E", 30);
				i.set("dtcolorline", '8');
				i.set("colorline1", '7');
				i.set("colorline2", '7');
				i.save(h);_c();
			}
			catch (IOException e)
			{
				getLogger().info("Can't load config:");
				e.printStackTrace();
			}
		}
	}	
	private void _l()
	{
		boolean f = false;
		File g = new File(getDataFolder(), "lang.yml");
		if (g.exists())
		{
			YamlConfiguration d = YamlConfiguration.loadConfiguration(g);
			l[0] = d.getString("YOU_HAVE_NO_PERM", "&cЯ не позволю Вам сделать это").replace("&", "§");
		    l[1] = d.getString("INVALID_ID_VALUE", "&3Указан недопустимый ID").replace("&", "§");
		    l[2] = d.getString("INCORRECT_COMMAND_USAGE", "&3Некоректное использование команды").replace("&", "§");
		    l[3] = d.getString("REPORT_DELETED", "&6Репорт ID:&b%id% &6удален").replace("&", "§");
		    l[4] = d.getString("REPORT_DOES_NOT_EXIST", "&cРепорта с таким ID не найдено").replace("&", "§");
		    l[5] = d.getString("PAGE_OF_AMOUNT_OF_PAGES", "&6Страница&2 %page% &6из&2 %amount%").replace("&", "§");
		    l[6] = d.getString("TOO_LARGE_PAGE_VALUE", "&3Указана неверная страница, всего&2 %amount% &3страниц").replace("&", "§");
		    l[7] = d.getString("INVALID_PAGE_VALUE", "&3Указана недопустимая страница").replace("&", "§");
		    l[8] = d.getString("DELAY_VALUE_HAS_BEEN_CHANGED", "&6Время задержки изменено на&2 %delay% &6секунд").replace("&", "§");
		    l[9] = d.getString("INVALID_DELAY_VALUE", "&cУказано недопустимое время").replace("&", "§");
		    l[10] = d.getString("AMOUNT_OF_ACTIVE_REPORTS", "&6Обнаружено&2 %amount% &6активных репортов").replace("&", "§");
		    l[11] = d.getString("NO_ANY_REPORTS", "&6В данный момент активных репортов нет").replace("&", "§");
		    l[12] = d.getString("DELAY_BETWEEN_DIFFERENT_REPORTS", "&3Интервал между репортами не должен быть меньше&2 %delay% &3секунд").replace("&", "§");
		    l[13] = d.getString("PLEASE_WAIT_A_TIME", "&6Подождите еще&2 %sec% &6секунд").replace("&", "§");
		    l[14] = d.getString("REPORT_HAS_BEEN_SENT", "&6Репорт отправлен").replace("&", "§");
		    l[15] = d.getString("PLAYER_REPORTED_A_TRASH", "&6Игрок&7 %name% &6пожаловался на мусор. ID:&2 %id%").replace("&", "§");
		    l[16] = d.getString("CMD_TR_USAGE", "&7/tr <описание> &f- &6Отправить репорт").replace("&", "§");
		    l[17] = d.getString("CMD_TR_LIST_USAGE", "&7/tr list [страница] &f- &6Список репортов с постраничной навигацией").replace("&", "§");
		    l[18] = d.getString("CMD_TR_GET_USAGE", "&7/tr get <id> &f- &6Телепортироваться на место").replace("&", "§");
		    l[19] = d.getString("CMD_TR_DEL_USAGE", "&7/tr del <id> &f- &6Удалить репорт").replace("&", "§");
		    l[20] = d.getString("CMD_TR_DELAY_USAGE", "&7/tr delay <секунды> &f- &6Изменить время задержки между репортами").replace("&", "§");
		    l[21] = d.getString("CMD_TR_ALL_USAGE", "&7/tr all &f- &6Показать полный список репортов").replace("&", "§");
		    l[22] = d.getString("USE_CMD_TO_DO_IT", "&6Используйте &7/tr list &6или &7/trep all ").replace("&", "§");
			l[23] = d.getString("DESCRIPTION_DOES_NOT_EXIST","&cОписание отсутствует").replace("&", "§");
			l[24] = d.getString("TRASH_LIST_ID","ID %id%: %time%").replace("&", "§");
			l[25] = d.getString("TRASH_LIST_SENDER","Отправитель: %sender%").replace("&", "§");
			l[26] = d.getString("TRASH_LIST_DESCRIPTION","Описание: %description%").replace("&", "§");
			l[27] = d.getString("YOU_HAVE_BEEN_TELEPORTED","&6Вы телепортированы на точку с ID&2 %id%").replace("&", "§");
			l[28] = d.getString("AN_ERROR_OCCURED", "&cПроизошла неизвестная ошибка. Сообщите администрации").replace("&", "§");
			l[29] = d.getString("REPORT_LIST_IS_NOT_EMPTY", "&cСписок репортов не пуст, вы не можете обнулить идентификацию").replace("&", "§");
			l[30] = d.getString("LAST_ID_EQUALS_NULL_NOW", "&6Идентификация и так равна нулю").replace("&", "§");
			l[31] = d.getString("WANT_TO_RESET", "&6Репортов больше нет, желаете обнулить идентификацию? &2/tr reset").replace("&", "§");
		}
		else
		{
			f = true;
			File e = new File(getDataFolder(), "lang.yml");
			if (!e.exists())
			{
			    InputStream resourceAsStream = getClass().getResourceAsStream("/me/ewerestr/trashreporter/lang.yml");
			    getDataFolder().mkdirs();
			    try
			    {
			        FileOutputStream fos = new FileOutputStream(e);
			        byte[] buff = new byte[65536];
			        int n;
			        while ((n = resourceAsStream.read(buff)) > 0)
			        {
			            fos.write(buff, 0, n);
			            fos.flush();
			        }
			        fos.close();
			        buff = null;
			    }
			    catch (Exception _e)
			    {
			        _e.printStackTrace();
			    }
			}			
			if (f) _l();
		}
	}
	
	public boolean s(String z)
	{
		try
		{
			Integer.parseInt(z);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}
	
	public Location _g(int o)
	{
		if (i.getConfigurationSection("R."+o) != null)
		{
			Location p = new Location(Bukkit.getWorld(i.getString("R."+o+".W")),i.getInt("R."+o+".X"),i.getInt("R."+o+".Y"),i.getInt("R."+o+".Z"),i.getInt("R."+o+".H"),i.getInt("R."+o+".V"));
			return p;
		}
		return null;
	}
	
	public byte _d(int _o)
	{
		if (i.getConfigurationSection("R."+_o) != null)
		{
			try
			{
				i.set("R."+_o, null);
				i.save(h);
				return 1;
			}
			catch (IOException e)
			{
				return 2;
			}
		}
		return 0;
	}
	public void _p(Player j,int n,int x)
	{
		if (i.getConfigurationSection("R") != null)
		{
			j.sendMessage("");
			List<String> d = new ArrayList<String>(i.getConfigurationSection("R").getKeys(false));
			char __o;
			for (int v = n; v < x; v++)
			{
				if ((v % 2) == 0) __o = I_; else __o = i_;
				_n(j,d.get(v),i.getString("R."+d.get(v)+".T"),i.getString("R."+d.get(v)+".S"),i.getString("R."+d.get(v)+".D"),__o);
				j.sendMessage("");
			}
		}
		else j.sendMessage(l[11]);
	}
	public void _n(Player _j,String u,String o,String d,String z,char k)
	{
		_j.sendMessage("§"+Character.toString(_i)+l[24].replace("%id%",u).replace("%time%",o));
    	_j.sendMessage("§"+Character.toString(k)+l[25].replace("%sender%",d));
    	_j.sendMessage("§"+Character.toString(k)+l[26].replace("%description%",z));
    }
	
	@EventHandler
	public void _j(PlayerJoinEvent b)
	{
		Player r = b.getPlayer();
		if (r.hasPermission("trashreporter.joinstat"))
		{
			if (i.getConfigurationSection("R") != null)
			{
				r.sendMessage(l[10].replace("%amount%",Integer.toString(i.getConfigurationSection("R").getKeys(false).size())));
				r.sendMessage(l[22]);
			}
		}
	}

	public String _s(int q)
	{
		return l[q];
	}
	
	public YamlConfiguration _x()
	{
		return i;
	}
	
	public void _y(int _b)
	{
		b = _b;
	}
	
	public boolean _e(UUID _u)
	{
		return _a.containsKey(_u);
	}
	
	public int _r(UUID _u)
	{
		return _a.get(_u);
	}
	
	public void _t()
	{
		c = 0;
	}
	
	public int _z()
	{
		return b;
	}
	
	public int _m()
	{
		return c;
	}
	
	public void _v()
	{
		c++;
	}
	
	public File _b()
	{
		return h;
	}
	
	public void _o(UUID u)
	{
		_a.put(u, ((int)(System.currentTimeMillis()/1000)+b));
	}
}
