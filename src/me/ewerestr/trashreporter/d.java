package me.ewerestr.trashreporter;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class d
{
	public d(a d, CommandSender b, String[] n)
	{
		if (b instanceof Player)
		{
			Player q = (Player)b;
			if (q.hasPermission("trashreporter.trash.get"))
			{
				if (n.length >= 2)
				{
					if (d.s(n[1]))
					{
						Location o = d._g(Integer.parseInt(n[1]));
						if (o != null)
						{
							q.teleport(d._g(Integer.parseInt(n[1])));
							q.sendMessage(d._s(27).replace("%id%", n[1]));
						}
						else q.sendMessage(d._s(4));
					}
					else q.sendMessage(d._s(1));
				}
				else q.sendMessage(d._s(2));
			}
			else q.sendMessage(d._s(0));
		}
		else b.sendMessage("You have to be a player");
	}
}
