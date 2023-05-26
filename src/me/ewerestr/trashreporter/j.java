package me.ewerestr.trashreporter;

import org.bukkit.command.CommandSender;

public class j
{
	public j(a j, CommandSender i)
	{
		if (i.hasPermission("trashreporter.limit"))
		{
			if (j.getConfig().getConfigurationSection("R") == null || j.getConfig().getConfigurationSection("R").getKeys(false).isEmpty())
			{
				j._t();
				i.sendMessage(j._s(30));
			}
			else i.sendMessage(j._s(29));
		}
		else i.sendMessage(j._s(0));
	}
}
