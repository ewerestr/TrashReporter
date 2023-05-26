package me.ewerestr.trashreporter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class i
{
	public i(a x_, CommandSender d, String[] q)
	{
		if (d instanceof Player)
		{
			Player g = (Player)d;
			if (g.hasPermission("trashreporter.trash.report"))
			{
				YamlConfiguration o = x_._x();
				int l = x_._m();
				boolean b = true;
				if (x_._e(g.getUniqueId()))
				{
					if (x_._r(g.getUniqueId()) > ((int)(System.currentTimeMillis()/1000)))
					{
						b = false;
						g.sendMessage(x_._s(12).replace("%delay%",Integer.toString(x_._z())));
						g.sendMessage(x_._s(13).replace("%sec%",Integer.toString((x_._r(g.getUniqueId())-((int)(System.currentTimeMillis()/1000))))));
					}
					else
					{
						g.sendMessage(x_._s(12).replace("%delay%", Integer.toString(x_._z())));
						g.sendMessage(x_._s(13).replace("%sec%", Integer.toString(x_._r(g.getUniqueId())-((int)(System.currentTimeMillis()/1000)))));
					}
				}
				if (b || g.hasPermission("trashreporter.unlimit"))
				{
					Date h = new Date();
					SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy hh:mm aa");
					String k;
					if (q != null)
					{
						k = q[0];
						if (q.length > 1)
						{
							for (int y = 1;y<q.length;y++)
							{
								k += " " + q[y];
							}
						}
					}
					else k = x_._s(23);
					try
					{
						o.set("R."+l+".W", g.getWorld().getName());
						o.set("R."+l+".X", g.getLocation().getBlockX());
						o.set("R."+l+".Y", g.getLocation().getBlockY());
						o.set("R."+l+".Z", g.getLocation().getBlockZ());
						o.set("R."+l+".H", g.getLocation().getYaw());
						o.set("R."+l+".V", g.getLocation().getPitch());
						o.set("R."+l+".S", g.getName());
						o.set("R."+l+".D", k);
						o.set("R."+l+".T", f.format(h));
						o.save(x_._b());
						g.sendMessage(x_._s(14));
						if (!g.hasPermission("trashreporter.unlimit")) x_._o(g.getUniqueId());
						Bukkit.broadcast(x_._s(15).replace("%name%",g.getName()).replace("%id%",Integer.toString(l)), "trashreporter.alarm");
						x_._v();
					}
					catch (IOException e)
					{
						g.sendMessage(x_._s(28));
					}
				}
			}
			else g.sendMessage(x_._s(0));
		}
	}
}
