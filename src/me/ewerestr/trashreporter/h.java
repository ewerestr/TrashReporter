package me.ewerestr.trashreporter;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class h
{
	public h(a c_, CommandSender _e, String[] a)
	{
		if (_e instanceof Player)
		{
			Player s = (Player)_e;
			if (s.hasPermission("trashreporter.trash.delete"))
			{
				if (a.length >= 2)
				{
					if (c_.s(a[1]))
					{
						byte r = c_._d(Integer.parseInt(a[1]));
						if (r == 1) s.sendMessage(c_._s(3).replace("%id%", a[1]));
						else if (r == 2) s.sendMessage(c_._s(28));
						else s.sendMessage(c_._s(4));
						if (c_.getConfig().getConfigurationSection("R") == null) Bukkit.broadcast(c_._s(31), "trashreporter.alarm");
					}
					else s.sendMessage(c_._s(4));
				}
				else s.sendMessage(c_._s(1));
			}
			else s.sendMessage(c_._s(2));
		}
		else _e.sendMessage("You have to be a player");
	}
}
