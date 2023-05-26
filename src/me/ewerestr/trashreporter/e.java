package me.ewerestr.trashreporter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class e implements CommandExecutor
{
	private a _f;
	
	public e(a _p)
	{
		_f=_p;
	}
	
	public boolean onCommand(CommandSender _d, Command m, String e, String[] _h)
	{
		if (m.getName().equalsIgnoreCase("trashreporter"))
		{
			if (_h.length >= 1)
			{
				if (_h[0].equalsIgnoreCase("get") || _h[0].equalsIgnoreCase("tp"))
				{
					new d(_f, _d, _h);
					return true;
				}
				else if (_h[0].equalsIgnoreCase("del") || _h[0].equalsIgnoreCase("remove"))
				{
					new h(_f, _d, _h);
					return true;
				}
				else if (_h[0].equalsIgnoreCase("list"))
				{
					new g(_f, _d, _h);
					return true;
				}
				else if (_h[0].equalsIgnoreCase("delay"))
				{
					new c(_f, _d, _h);
					return true;
				}
				else if (_h[0].equalsIgnoreCase("all"))
				{
					new b(_f, _d, _h);
					return true;
				}
				else if (_h[0].equalsIgnoreCase("help"))
				{
					new f(_f, _d);
					return true;
				}
				else if (_h[0].equalsIgnoreCase("reset"))
				{
					new j(_f, _d);
					return true;
				}
				else new i(_f, _d, _h);
			}
			else new i(_f, _d, null);
		}
		return true;
	}
}
