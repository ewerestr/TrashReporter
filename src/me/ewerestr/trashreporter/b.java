package me.ewerestr.trashreporter;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class b
{
	public b(a _a, CommandSender _p, String[] _h)
	{
		if (_p instanceof Player)
		{
			Player _v = (Player)_p;
			if (_v.hasPermission("trashreporter.trash.list.all"))
			{
				YamlConfiguration d = _a._x();
				if (d.getConfigurationSection("R") != null)
				{
					_v.sendMessage(_a._s(10).replace("%amount%",Integer.toString(d.getConfigurationSection("R").getKeys(false).size())));
					//int _b = 0;
					//char n_a;
					for (String g : d.getConfigurationSection("R").getKeys(false))
					{
						//if ((_b % 2) == 0) n_a = '2'; else n_a = '6';
						//_a._n(_v,g,d.getString("R."+g+".T"),d.getString("R."+g+".S"),d.getString("R."+g+".D"),n_a);
						_v.sendMessage("ID: "+g+" | Дата: "+d.getString("R."+g+".T")+" | Отправитель: "+d.getString("R."+g+".S"));
					}
				}
				else _v.sendMessage(_a._s(11));
			}
			else _v.sendMessage(_a._s(0));
		}
		else _p.sendMessage("You have to be a player");
	}
}
