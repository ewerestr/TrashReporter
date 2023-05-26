package me.ewerestr.trashreporter;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class c
{
	public c(a _e, CommandSender _l, String[] _m)
	{
		if (_l instanceof Player)
		{
			Player b = (Player)_l;
			if (b.hasPermission("trashreporter.delay"))
			{
				if (_m.length >= 2)
				{
					if (_e.s(_m[1]))
					{
						_e._y(Integer.parseInt(_m[1]));
						b.sendMessage(_e._s(8).replace("%delay%",_m[1]));
					}
					else b.sendMessage(_e._s(9));
				}
				else b.sendMessage(_e._s(2));
			}
			else b.sendMessage(_e._s(0));
		}
		else _l.sendMessage("You have to be a player");
	}
}
