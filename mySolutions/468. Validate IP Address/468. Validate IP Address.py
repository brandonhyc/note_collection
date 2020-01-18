class Solution:
    def validIPAddress(self, IP: str) -> str:
        ipv4 = IP.split(".")
        ipv6 = IP.split(":")
        
        if len(ipv4) == 4 and self.isIPv4(ipv4):
            return "IPv4"
        
        if len(ipv6) == 8 and self.isIPv6(ipv6):
            return "IPv6"
        
        return "Neither"
    
        
    def isIPv4(self, ipArray):
        try: 
            for part in ipArray:
                if str(int(part)) != part:
                    return False
                if int(part) < 0 or int(part) > 255:
                    return False
            return True
        except: return False
        
    def isIPv6(self, ipArray):
        try:
            for part in ipArray:
                if len(part) > 4:
                    return False
                if part[0] == '-' or int(part, 16) < 0:
                    return False
                
            return True
        except: return False
                
        